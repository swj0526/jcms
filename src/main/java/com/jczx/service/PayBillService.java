package com.jczx.service;

import com.jczx.bean.RemindBean;
import com.jczx.domain.TbAttachment;
import com.jczx.domain.TbPayBill;
import com.jczx.system.SC;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.db.parser.JdbcParser;
import net.atomarrow.util.StringUtil;
import net.atomarrow.util.excel.ExcelDatas;
import net.atomarrow.util.excel.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 缴费
 *
 * @author 丛枭钰
 * @create 2019-11-21 21:37
 */
@Component
 public class PayBillService extends BaseService {

    @Autowired
    private RecruitService recruitService;
    @Autowired
    private IntegralService integralService;
    @Autowired
    private AttachmentService attachmentService;
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;
    /**
     * 添加
     *
     * @param payBill
     * @return
     */
    public ServiceResult addBill(TbPayBill payBill) {
        if (payBill.getStudentId() == null
                || payBill.getTotalAmount() == null
                || payBill.getPayDate() == null
                || payBill.getPayAmount() == null
                || payBill.getFactAmount() == null
                || payBill.getStartTime() == null
                || payBill.getEndTime() == null) {
            return error("必选项为空");
        }

        payBill.setCreateTime(SC.getNowDate());
        add(payBill);
        recruitService.modifyOne(payBill.getStudentId());
        integralService.addList(payBill.getStudentId());
        userService.addStudentUser(studentService.get(payBill.getStudentId()));
        return SUCCESS;
    }

    /**
     * 修改
     *
     * @return
     */
    public ServiceResult modifyBill(TbPayBill payBill) {
        if (payBill.getTotalAmount() == null
                || payBill.getPayDate() == null
                || payBill.getPayAmount() == null
                || payBill.getFactAmount() == null
                || payBill.getStartTime() == null
                || payBill.getEndTime() == null) {
            return error("必选项为空");
        }
        modify(payBill);
        return SUCCESS;
    }

    /**
     * 查询
     *
     * @return
     */
    public List<TbPayBill> listBill(String time, String keyword, Integer typeId, Pager pager) {
        Conditions conditions = new Conditions(getTableName());
        conditions.setSelectValue("paybill.id,student.name,paymentMethodId,semesterId,typeId,studentId ,totalAmount,payDate,hasInstalment,discountAmount,payAmount,factAmount,startTime,endTime,paybill.remark");
        conditions.setJoin(" paybill LEFT JOIN tbstudent student ON studentId=student.id");
        if (StringUtil.isNotBlank(keyword)) {
            conditions.parenthesesStart();
            conditions.putLIKE("student.name", keyword);
            conditions.or();
            conditions.putLIKE("paybill.remark", keyword);
            conditions.parenthesesEnd();
        }
        if (StringUtil.isNotBlank(time)) {
            String[] split = time.split(" - ");
            conditions.putBW("paybill.payDate", split[0], split[1]);
        }
        conditions.putEWIfOk("paybill.typeId", typeId);
        if (pager == null) {
            List<TbPayBill> list = getList(conditions);
            return list;
        }
        pager.setDataTotal(getCount(conditions));
        List<TbPayBill> list = getListByPage(conditions, pager);
        return list;
    }

    /**
     * 修改查询
     *
     * @param id
     * @return
     */
    public TbPayBill getBill(int id) {
        Conditions conditions = getConditions();
        conditions.putEW("id", id);
        TbPayBill PayBill = getOne(conditions);
        return PayBill;
    }

    /**
     * 导出
     *
     * @param time
     * @param keyword
     * @param type
     * @param pager
     * @return
     */
    public InputStream exportExcel(String time, String keyword, Integer type, Pager pager) {
        ExcelDatas excelDatas = new ExcelDatas();
        List<TbPayBill> tbPayBill = listBill(time, keyword, type, pager);
        excelDatas.addStringArray(0, 0, new String[]{"序号", "姓名", "性别", "出生年月", "联系方式", "学年", "缴费类型", "缴费方式", "总金额", "是否分期", "缴费日期", "优惠金额", "金额", "总计", "开始时间", "结束时间", "备注"});
        excelDatas.addObjectList(1, 0, tbPayBill, new String[]{"id", "name", "sex", "birthDate", "studentPhone", "semesterName", "typeName", "paymentMethodName", "totalAmount", "instalment", "payDate", "discountAmount", "payAmount", "factAmount", "startTime", "endTime", "remark"});
        InputStream inputStream = ExcelUtil.exportExcel(excelDatas);
        return inputStream;
    }

    /**
     * 检查学年
     *
     * @param id
     * @return
     */
    public List<TbPayBill> termCount(Integer id) {
        Conditions conditions = getConditions();
        conditions.putEW("semesterId", id);
        return getList(conditions);
    }

    /**
     * 检查类型
     *
     * @param id
     * @return
     */
    public List<TbPayBill> typeCount(Integer id) {
        Conditions conditions = getConditions();
        conditions.putEW("typeId", id);
        return getList(conditions);
    }

    /**
     * 上传
     * @param file
     * @param path
     * @param linkId
     * @param studentID
     * @return
     */
    public ServiceResult uploadFile(MultipartFile file, String path,Integer linkId,Integer studentID) {
        ServiceResult result = upload(file, path);
        Integer id=0;
        if (result.isSuccess()) {
            TbAttachment attachment = new TbAttachment();//
            attachment.setCreateTime(SC.getNowDate());
            attachment.setOperatorId(SC.getOperatorId());
            attachment.setType(TbAttachment.TYPE_BILL);
            attachment.setURL(result.getResult() + "");
            attachment.setLinkId(linkId);
            attachment.setStudentId(studentID);
            attachment.setName(file.getOriginalFilename());
            ServiceResult attachmentResult = attachmentService.addAttachment(attachment);
            id= (Integer) attachmentResult.getResult();
        }
        result.setResult(id);
        return result;
    }

    /**
     * 检查方法
     *
     * @param id
     * @return
     */
    public List<TbPayBill> methodCount(Integer id) {
        Conditions conditions = getConditions();
        conditions.putEW("paymentMethodId", id);
        return getList(conditions);
    }

    @Override
    public String getTableName() {
        return TbPayBill.class.getSimpleName();
    }

    /**
     * 返回缴费提醒的列表
     * @return
     */
    public List<RemindBean>  ListRemind(String keywords, String startTime, Pager pager){
        Conditions conditions = getConditions();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time = dateFormat.format(date);
        Date endTime = null;
        try {
            endTime = dateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        conditions.setSelectValue("*");
        conditions.setJoin(" payBill join TbStudent  student on payBill.studentId = student.id");
        conditions.putGT("payBill.endTime",endTime);

        conditions.putLIKEIfOK("student.name",keywords);

        if (StringUtil.isNotBlank(startTime)) {
            String[] splitTime = startTime.split(" - ");
            conditions.putBW("startTime", splitTime[0], splitTime[1]);
        }

        List<TbPayBill> list = getListByPage(conditions,pager);
        List<RemindBean> remindList = new ArrayList<>();
        for(TbPayBill pay:list){
            Date startDate = pay.getStartTime();
            Date endDate = pay.getEndTime();
            int day = getDay(startDate, endDate);

            if(day<=30){
                System.out.println("小于30");
                RemindBean remindBean = new RemindBean();
                remindBean.setEndTime(pay.getEndTime());
                remindBean.setFactAmount(pay.getFactAmount());
                remindBean.setMajorName(pay.getMajorName());
                remindBean.setName(pay.getName());
                remindBean.setPayDate(pay.getPayDate());
                remindBean.setStartTime(pay.getStartTime());
                remindList.add(remindBean);
            }

        }
        System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
        return remindList;
    }

    /**
     *导出提醒信息
     * @param keywords
     * @param startTime
     * @return
     */
    public InputStream RemindExcel(String keywords, String startTime){
        List<RemindBean> list = ListRemind(keywords, startTime, null);
        ExcelDatas excelDatas = new ExcelDatas();
        excelDatas.addStringArray(0, 0, new String[]{"姓名/学号", "专业-班级", "上次缴费时间", "上次交费金额", "学费到期时间"});
        excelDatas.addObjectList(1, 0, list, new String[]{"name", "majorName", "startTime", "factAmount", "endTime"});
        InputStream inputStream = ExcelUtil.exportExcel(excelDatas);
        return inputStream;
    }


}
