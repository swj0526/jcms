package com.jczx.service;

import com.jczx.domain.TbMajor;
import com.jczx.domain.TbStudent;
import com.jczx.system.SC;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 孙文举
 * @description
 * @create 2019-11-26 17:00
 */
@Component
public class MajorService extends BaseService {

    @Autowired
    private StudentService studentService;

    @Override
    public String getTableName() {
        return TbMajor.class.getSimpleName();
    }

    /**
     * 增加专业信息
     *
     * @param major
     * @return
     */
    public ServiceResult addMajor(TbMajor major) {
        if (StringUtil.isBlank(major.getName())) {
            return error("");
        }
        major.setPid(0);
        major.setCreateTime(SC.getNowDate());
        major.setOperatorId(SC.getOperatorId());
        add(major);
        return SUCCESS;
    }

    /**
     * 增加班级信息
     *
     * @param major
     * @return
     */
    public ServiceResult addClass(TbMajor major) {
        if (major.getPid() == null || major.getPid() == 0) {
            return error("");
        }
        if (StringUtil.isBlank(major.getName())) {
            return error("");
        }
        major.setName(major.getName());
        major.setPid(major.getPid());
        major.setCreateTime(SC.getNowDate());
        major.setOperatorId(SC.getOperatorId());
        add(major);
        return SUCCESS;
    }

    /**
     * 修改班级专业信息
     *
     * @param major
     * @return
     */
    public ServiceResult modifyMajor(TbMajor major) {
        if (StringUtil.isBlank(major.getName())) {
            return error("");
        }
        modify(major);
        return SUCCESS;
    }

    /**
     * 返回班级-专业列表
     *
     * @return
     */
    public List<TbMajor> listMajor(String keywords) {
        System.out.println(keywords + "=========");
        Conditions conditions = getConditions();
        List<TbMajor> list = getList(conditions);
        List<TbMajor> majorList = new ArrayList<>();

        if (StringUtil.isBlank(keywords)) {
            keywords = "";
        }

        System.out.println(keywords);
        for (TbMajor major : list) {
            System.out.println(major.getName().toString() + "=876554==");
            if (major.getPid() == 0) {
                System.out.println(keywords + "==进入");
                majorList.add(major);
                for (TbMajor grade : list) {
                    if (major.getId() == grade.getPid() && grade.getName().contains(keywords)) {
                        majorList.add(grade);
                    }
                }
            }
        }
       /* for(TbMajor major:majorList){
            System.out.println(major.getName());
        }*/
        return majorList;
    }

  /*  private List<TbMajor> listByKeywords(String keywords) {

        if (StringUtil.isNotBlank(keywords)) {
            conditions.parenthesesStart();
            conditions.putLIKE("name", keywords);
            conditions.or();
            conditions.putLIKE("remark", keywords);
            conditions.parenthesesEnd();
         }
        return getList(conditions);
    }*/

    /**
     * 修改的时候使用,根据id去获取值,在弹窗上赋值显示
     *
     * @param id
     * @return
     */
    public TbMajor getMajor(Integer id) {
        TbMajor major = getById(getTableName(), id);
        return major;
    }

    public ServiceResult deleteMajor(Integer id) {
        TbMajor major = getById(getTableName(), id);
        if (major.getPid() == 0) { //删除专业
            Conditions conditions = getConditions();
            conditions.putEW("pid", major.getId());
            List<TbMajor> list = getList(conditions);
            if (list.size() != 0) {
                return error("该专业有班级,不可删除!");
            } else {
                delById(getTableName(), id);
                return SUCCESS;
            }
        } else { //删除班级
            List<TbStudent> list = studentService.checkMajor(id);
            if (list.size() != 0) {
                return error("该班级有学生,不可删除!");
            } else {
                delById(getTableName(), id);
                return SUCCESS;
            }

        }
    }
}