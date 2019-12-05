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
            return error("专业名称不可为空!");
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
        if (StringUtil.isBlank(major.getName())) {
            return error("班级名称不可为空!");
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
            return error("名称不可为空!");
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
        Conditions conditions = getConditions();
        List<TbMajor> list = getList(conditions);
        List<TbMajor> majorList = new ArrayList<>();
        if (StringUtil.isBlank(keywords)) {
            keywords = "";
        }
        for (TbMajor major : list) {
            if (major.getPid() == 0 && (major.getName().contains(keywords) || major.getRemark().contains(keywords))) {
                majorList.add(major);
                for (TbMajor grade : list) {
                    if (major.getId() == grade.getPid()) {
                        majorList.add(grade);
                    }
                }
            }
        }
        return majorList;
    }


    public ServiceResult deleteMajor(Integer id) {
        TbMajor major = getById(id);
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
            List<TbStudent> list = studentService.majorCount(id);
            if (list.size() != 0) {
                return error("该班级有学生,不可删除!");
            } else {
                delById(getTableName(), id);
                return SUCCESS;
            }

        }
    }
}