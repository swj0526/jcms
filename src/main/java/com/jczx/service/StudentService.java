package com.jczx.service;

import com.jczx.domain.TbStudent;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.db.parser.JdbcParser;
import net.atomarrow.util.StringUtil;
import net.atomarrow.util.excel.ExcelDatas;
import net.atomarrow.util.excel.ExcelUtil;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

/**
 * @author 于振华
 * @create 2019-11-28 13:06
 */
@Component
public class StudentService extends BaseService {

    /**
     * @author 丛枭钰
     * @create 2019-11-28 13:06
     */
    public TbStudent get(String student) {
        Conditions conditions = getConditions();
        System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
        conditions.putEW("name",student);
        TbStudent one = getOne(conditions);
        return one;
    }

    /**
     * 于振华
     * 查询所在班级
     *
     * @param majorId
     * @return
     */
    public List<TbStudent> checkMajor(Integer majorId) {
        Conditions conditions = getConditions();
        conditions.putEW("majorId", majorId);
        return getList(conditions);
    }

    /**
     * 于振华
     * 查询渠道
     *
     * @param channelId
     * @return
     */
    public List<TbStudent> checkChannel(Integer channelId) {
        Conditions conditions = getConditions();
        conditions.putEW("channelId", channelId);
        return getList(conditions);
    }




    /**
     * 查询入学学生信息
     *
     * @param
     * @return
     */
    public List<TbStudent> listStudent(String keywords,String  admissionData,Integer studentState, Pager pager) {
        Conditions conditions = getConditions();
        if (StringUtil.isNotBlank(keywords)){
            conditions.parenthesesStart();
            conditions.putLIKE("name",keywords);
            conditions.or();
            conditions.putLIKE("studentNumber",keywords);
            conditions.or();
            conditions.putLIKE("studentPhone",keywords);
            conditions.parenthesesEnd();
        }
        if (studentState!=null){
            String state=admissionData.substring(0,10);
            String end=admissionData.substring(13);
            if (studentState==TbStudent.STATE_AT_SCHOOL){//在校
                conditions.putBW("admissionData",state,end);
            }
            if (studentState==TbStudent.STATE_GRADUATE){//毕业
                conditions.putBW("graduationDate",state,end);
            }
        }

        conditions.putEWIfOk("state", TbStudent.STATE_AT_SCHOOL);//缺少缴费字段
        if (pager==null){
            List<TbStudent> list = getList(conditions);
            return list;
        }
        pager.setDataTotal(getCount(conditions));
        List<TbStudent> list = getListByPage(conditions,pager);
        System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
        return list;
    }

    /**
     * 查询当前学生信息
     *
     * @param id
     * @return
     */
    public TbStudent getStudent(Integer id) {
        return getById(id);
    }

    /**
     * 修改学生的基本信息
     * @param student
     * @return
     */
    public ServiceResult modifyStudent(TbStudent student){
        if (StringUtil.isBlank(student.getName())
                ||StringUtil.isBlank(String.valueOf(student.getAge()))
                ||StringUtil.isBlank(student.getNation())
                ||StringUtil.isBlank(student.getIDCard().toString())
                ||StringUtil.isBlank(student.getState().toString())
                ||StringUtil.isBlank(student.getAddress())
                ||StringUtil.isBlank(student.getNativePlace())
                ||student.getAdmissionData()==null){
            return error("姓名,年龄,民族,身份证,在校状态,家庭住址,籍贯");
        }

        modify(student);
        return SUCCESS;
    }




    /**
     * excel 导出
     * @param keywords
     * @param
     * @param
     * @param
     * @param
     * @return
     */
    public InputStream studentExcel(String keywords,String  admissionData ,Integer studentState,Pager pager) {
        ExcelDatas excelDatas = new ExcelDatas();
        List<TbStudent> list = listStudent(keywords, admissionData, studentState,null);
        excelDatas.addStringArray(0, 0, new String[]{"学号","姓名", "民族", "性别", "出生年月", "年龄","身份证号", "联系方式", "入学时间", "毕业时间", "籍贯", "qq", "微信"});
        excelDatas.addObjectList(1, 0, list, new String[]{"studentNumber","name", "nation", "sex", "birthDate","age", "IDCard", "studentPhone","admissionData", "graduationDate", "nativePlace","qq", "weChat"});
        InputStream inputStream = ExcelUtil.exportExcel(excelDatas);
        return inputStream;
    }

    @Override
    public String getTableName() {
        return TbStudent.class.getSimpleName();
    }
}
