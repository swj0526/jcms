package com.jczx.service;

import com.jczx.domain.TbPayBill;
import com.jczx.system.SC;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.util.StringUtil;
import net.atomarrow.util.excel.ExcelDatas;
import net.atomarrow.util.excel.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

/**
 * 缴费
 *
 * @author 丛枭钰
 * @create 2019-11-21 21:37
 */
@Component
public class PayBIllService extends BaseService {
    @Autowired
   private StudentService studentService;
    /**
     * 添加
     *
     * @param payBill
     * @return
     */
    public ServiceResult addBill(TbPayBill payBill) {
        if (StringUtil.isBlank(payBill.getName())
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
        return SUCCESS;
    }

    /**
     * 修改
     *
     * @return
     */
    public ServiceResult modifyBill(TbPayBill payBill) {
        if (StringUtil.isBlank(payBill.getName())
                || payBill.getTotalAmount() == null
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
    public List<TbPayBill> listBill(String time,String keyword,Integer typeId, Pager pager) {
        Conditions conditions = new Conditions(getTableName());
        conditions.setSelectValue("paybill.id,student.name,paymentMethodId,semesterId,typeId,studentId ,totalAmount,payDate,hasInstalment,discountAmount,payAmount,factAmount,startTime,endTime,paybill.remark");
        conditions.setJoin(" paybill LEFT JOIN tbstudent student ON studentId=student.id");
        if (StringUtil.isNotBlank(keyword)){
            conditions.parenthesesStart();
            conditions.putLIKE("student.name",keyword);
            conditions.or();
            conditions.putLIKE("paybill.remark",keyword);
            conditions.parenthesesEnd();
        }
        if (StringUtil.isNotBlank(time)){
            String[] split = time.split(" - ");
            conditions.putBW("paybill.payDate",split[0],split[1]);
        }
        conditions.putEWIfOk("paybill.typeId",typeId);
        if (pager==null){
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
        conditions.putEW("paybill.id",id);
        TbPayBill PayBill = getOne(conditions);
        return PayBill;
    }

    /**
     * 导出
     * @param time
     * @param keyword
     * @param type
     * @param pager
     * @return
     */
    public InputStream exportExcel(String time, String keyword, Integer type, Pager pager){
        ExcelDatas excelDatas = new ExcelDatas();
        List<TbPayBill> tbPayBill = listBill(time,keyword, type, pager);
        excelDatas.addStringArray(0,0,new String[]{"序号","姓名","性别","出生年月","联系方式","学年","缴费类型","缴费方式","总金额","是否分期","缴费日期","优惠金额","金额","总计","开始时间","结束时间","备注"});
        excelDatas.addObjectList(1,0,tbPayBill,new String[]{"id","name","sex","birthDate","studentPhone","semesterName","typeName","paymentMethodName","totalAmount","instalment","payDate","discountAmount","payAmount","factAmount","startTime","endTime","remark"});
        InputStream inputStream = ExcelUtil.exportExcel(excelDatas);
        return inputStream;
    }

    /**
     * 检查学年
     * @param id
     * @return
     */
    public List<TbPayBill> termCount(Integer id){
        Conditions conditions =getConditions();
        conditions.putEW("semesterId",id);
        return getList(conditions);
    }

    /**
     * 检查类型
     * @param id
     * @return
     */
    public List<TbPayBill> typeCount(Integer id){
        Conditions conditions = getConditions();
        conditions.putEW("typeId",id);
        return getList(conditions);
    }

    /**
     * 检查方法
     * @param id
     * @return
     */
    public List<TbPayBill> methodCount(Integer id){
        Conditions conditions = getConditions();
        conditions.putEW("paymentMethodId",id);
        return getList(conditions);
    }

    @Override
    public String getTableName() {
        return TbPayBill.class.getSimpleName();
    }
}
