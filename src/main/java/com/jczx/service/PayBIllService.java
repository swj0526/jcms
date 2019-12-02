package com.jczx.service;

import com.jczx.domain.TbPayBill;
import com.jczx.domain.TbStudent;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.db.parser.JdbcParser;
import net.atomarrow.util.StringUtil;
import net.atomarrow.util.excel.ExcelDatas;
import net.atomarrow.util.excel.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Date;
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
            return error("");
        }
        TbStudent tbStudent = studentService.get(payBill.getName());
        if (tbStudent==null){
            return error("姓名未找到");
        }
        payBill.setStudentId(tbStudent.getId());
        add(payBill);
        return success(true);
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
            return error("");
        }
        TbStudent tbStudent = studentService.get(payBill.getName());
        if (tbStudent==null){
            return error("姓名未找到");
        }
        payBill.setStudentId(tbStudent.getId());
        int modify = modify(payBill);
        return success(true);
    }

    /**
     * 查询
     *
     * @return
     */
    public List<TbPayBill> listBill(String time,String keyword,Integer typeId, Date date, Pager pager) {
        Conditions conditions = new Conditions(getTableName());
        conditions.setSelectValue("tbpaybill.id,tbstudent.name,paymentMethodId,semesterId,typeId,studentId ,totalAmount,payDate,hasInstalment,discountAmount,payAmount,factAmount,startTime,endTime,tbpaybill.remark");
        conditions.setJoin(" LEFT JOIN tbstudent ON studentId=tbstudent.id"); //Left join tbdictionary on typeId=tbdictionary.id");
        if (StringUtil.isNotBlank(keyword)){
            conditions.parenthesesStart();
            conditions.putLIKE("name",keyword);
            conditions.or();
            conditions.putLIKE("remark",keyword);
            conditions.parenthesesEnd();
        }
        if (StringUtil.isNotBlank(time)){
            String state=time.substring(0,10);
            String end=time.substring(13);
            conditions.putBW("payDate",state,end);
        }
        conditions.putEWIfOk("typeId",typeId);
        if (date!=null){
            //conditions.putLIKE("payDate",date);
        }
        pager.setDataTotal(getCount(conditions));
        System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
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
        Conditions conditions =new Conditions(getTableName());
        conditions.setJoin(" LEFT JOIN tbstudent ON studentId=tbstudent.id");
        conditions.setSelectValue("tbpaybill.id,tbstudent.name,sex,birthDate,paymentMethodId,semesterId,typeId,studentId ,totalAmount,payDate,hasInstalment,discountAmount,payAmount,factAmount,startTime,endTime,tbpaybill.remark");
        conditions.putEW("tbpaybill.id",id);
        TbPayBill one = getOne(conditions);
        System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
        return one;
    }
    public InputStream xlsx(String time,String keyword, Integer type, Date date, Pager pager){
        ExcelDatas excelDatas = new ExcelDatas();
        List<TbPayBill> tbPayBill = listBill(time,keyword, type, date, pager);
        excelDatas.addStringArray(0,0,new String[]{"序号","姓名","性别","出生年月","联系方式","学年","缴费类型","缴费方式","总金额","是否分期","缴费日期","优惠金额","金额","总计","开始时间","结束时间","备注"});
        excelDatas.addObjectList(1,0,tbPayBill,new String[]{"id","name","sex","birthDate","studentPhone","semesterName","typeName","paymentMethodName","totalAmount","instalment","payDate","discountAmount","payAmount","factAmount","startTime","endTime","remark"});
        InputStream inputStream = ExcelUtil.exportExcel(excelDatas);
        return inputStream;
    }
    public List<TbPayBill> checkTerm(Integer id){
        Conditions conditions =getConditions();
        conditions.putEW("semesterId",id);
        return getList(conditions);
    }
    public List<TbPayBill> checkType(Integer id){
        Conditions conditions = getConditions();
        conditions.putEW("typeId",id);
        return getList(conditions);
    }
    public List<TbPayBill> checkMethod(Integer id){
        Conditions conditions = getConditions();
        conditions.putEW("paymentMethodId",id);
        return getList(conditions);
    }

    @Override
    public String getTableName() {
        return TbPayBill.class.getSimpleName();
    }
}