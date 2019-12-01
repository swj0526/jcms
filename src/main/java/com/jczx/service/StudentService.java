package com.jczx.service;

import com.jczx.domain.TbStudent;
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

import java.io.InputStream;
import java.util.List;

/**
 * @author 于振华
 * @create 2019-11-28 13:06
 */
@Component
public class StudentService extends BaseService {
    @Autowired
    private RecruitService recruitService;

    /**
     * @author 丛枭钰
     * @create 2019-11-28 13:06
     */
    public TbStudent get(String student) {
        Conditions conditions = new Conditions(getTableName());
        System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
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
     * @param student
     * @return
     */
    public List<TbStudent> listStudent(TbStudent student, Pager pager) {
        Conditions conditions = getConditions();

        conditions.putEWIfOk("state", TbStudent.STATE_ENTRANCE);
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
        return getById(getTableName(), id);
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
            return error("");
        }
        student.setCreateTime(SC.getNowDate());//操作时间
        student.setOperatorId(SC.getOperatorId());//操作人
        modify(student);
        return SUCCESS;
    }




    /**
     * excel 导出
     * @param keywords
     * @param createTime
     * @param labelIds
     * @param sex
     * @param pager
     * @return
     */
    public InputStream studentExcel(String keywords, String createTime, String labelIds, String sex, Pager pager) {
        ExcelDatas excelDatas = new ExcelDatas();
        List<TbStudent> list = recruitService.listRecruit(keywords, createTime, labelIds, sex, pager);//调用查询信息
        excelDatas.addStringArray(0, 0, new String[]{"姓名", "性别", "意向", "出生年月", "学校", "手机号", "QQ号", "微信", "渠道"});
        excelDatas.addObjectList(1, 0, list, new String[]{"name", "sex", "labelIds", "birthDate", "school", "studentPhone", "qq", "weChat", "channelId"});
        InputStream inputStream = ExcelUtil.exportExcel(excelDatas);
        return inputStream;
    }


    @Override
    public String getTableName() {
        return TbStudent.class.getSimpleName();
    }
}
