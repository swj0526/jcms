package com.jczx.service;

import com.jczx.domain.TbInternship;
import com.jczx.domain.TbStudent;
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
import java.io.Serializable;
import java.util.List;

/**
 * 招生
 *
 * @author 于振华
 * @create 2019-11-21 19:38
 */
@Component
public class RecruitService extends BaseService {
    @Autowired
    private InternshipService internshipService;
    /**
     * 添加
     *
     * @param student
     * @return
     */
    public ServiceResult addRecruit(TbStudent student, Integer entranceState) {
        if (StringUtil.isBlank(student.getName())//学生姓名
                || StringUtil.isBlank(student.getLabelIds())//意向标签
                || StringUtil.isBlank(student.getStudentPhone())//学生电话
                || StringUtil.isBlank(student.getSex())//学生性别
        ) {
            return error("姓名,意向,学生电话,性别必须填写");
        }
        student.setCreateTime(SC.getNowDate());//操作时间
        student.setOperatorId(SC.getOperatorId());//操作人
        add(student);
        if (TbStudent.STATE_NOT_ENTRANCE == entranceState) {
            Integer id = student.getId();
            String name = student.getName();
            TbInternship internship = new TbInternship();
            internship.setStudentId(id);
            internship.setName(name);
            internshipService.addInternship(internship);//试课
        }
        return SUCCESS;
    }
    /**
     * 修改
     * @param student
     * @return
     */
    public ServiceResult modifyRecruit(TbStudent student) {
        modify(student);
        return SUCCESS;
    }
    /**
     * 修改学生是否入学 缴费
     * 给丛
     *
     * @param student
     * @return
     */
    public ServiceResult modifyOne(Integer student) {
        Conditions conditions = getConditions();
        conditions.putEW("id", student);
        modifyWithColumn(conditions, new Serializable[]{"entranceState", TbStudent.STATE_ENTRANCE, "schoolState", TbStudent.STATE_AT_SCHOOL});
        return SUCCESS;
    }

    /**
     * 删除
     *
     * @param student
     * @return
     */
    public ServiceResult deleteRecruit(TbStudent student) {
        del(student);
        return SUCCESS;
    }


    /**
     * 查询
     */
    public List<TbStudent> listRecruit(String keywords, String labelIds, String createTime, Integer channelId, String sex, Pager pager) { //模糊关键字keywords查询用or
        Conditions conditions = getConditions();
        if (StringUtil.isNotBlank(keywords)) {
            conditions.parenthesesStart();
            conditions.putLIKE("name", keywords);//判断是否为空
            conditions.or();
            conditions.putLIKE("school", keywords);
            conditions.or();
            conditions.putLIKE("motherPhone", keywords);
            conditions.or();
            conditions.putLIKE("fatherPhone", keywords);
            conditions.or();
            conditions.putLIKE("qq", keywords);
            conditions.or();
            conditions.putLIKE("weChat", keywords);
            conditions.or();
            conditions.putLIKE("studentPhone", keywords);
            conditions.parenthesesEnd();
        }

        if (StringUtil.isNotBlank(labelIds)) {
            conditions.putLIKE("labelIds", "," + labelIds + ",");
        }
        if (channelId != null) {
            conditions.putLIKE("channelId", channelId);
        }
        /* conditions.putEWIfOk("createTime",createTime);*/
        conditions.putEWIfOk("sex", sex);
        if (pager == null) {
            List<TbStudent> listStudent = getList(conditions);
            return listStudent;
        }

        pager.setDataTotal(getCount(conditions));//调用分页之前给设置总条数
        List<TbStudent> listStudent = getListByPage(conditions, pager);
        return listStudent;

    }

    /**
     * 导出
     *
     * @param keywords
     * @param labelIds
     * @param sex
     * @param
     * @return
     */
    public InputStream studentExcel(String keywords, String createTime, String labelIds, String sex, Integer channelId) {
        ExcelDatas excelDatas = new ExcelDatas();
        List<TbStudent> list = listRecruit(keywords, createTime, labelIds, channelId, sex, null);//调用查询信息
        excelDatas.addStringArray(0, 0, new String[]{"姓名", "性别", "意向", "出生年月", "学校", "手机号", "QQ号", "微信", "渠道"});
        excelDatas.addObjectList(1, 0, list, new String[]{"name", "sex", "labelNames", "birthDate", "school", "studentPhone", "qq", "weChat", "channelName"});

        InputStream inputStream = ExcelUtil.exportExcel(excelDatas);
        return inputStream;
    }


    /**
     * 导入学生信息
     *
     * @return
     */
    public InputStream inputStudent(String path) throws Throwable {

        //解析标题必须按照顺序去填写字段名
        List<TbStudent> listStudent = ExcelUtil.getListFromExcel(path, TbStudent.class, new String[]{"name", "age"}, new boolean[]{false, false}, 2, null);

        for (TbStudent list : listStudent) {
            System.out.println(list.getName());
            System.out.println(list.getAge());

        }
        addByBatch(listStudent);
        return null;
    }

    /**
     * 判断是否已经入学
     *
     * @return
     */
    public ServiceResult hasEntrance(Integer id) {
        TbStudent student = getById(id);
        if (student.getEntranceState() == TbStudent.STATE_NOT_ENTRANCE) {
            return error("未入学");
        }
        return SUCCESS;
    }

    /**
     * 下载模板
     *
     * @return
     */
    public InputStream excel() {
        ExcelDatas excelDatas = new ExcelDatas();
        excelDatas.addStringArray(0, 0, new String[]{"姓名", "性别", "出生年月", "学校", "手机号", "QQ号", "微信", "渠道"});
        InputStream inputStream = ExcelUtil.exportExcel(excelDatas);
        return inputStream;
    }

    @Override
    public String getTableName() {
        return TbStudent.class.getSimpleName();
    }
}
