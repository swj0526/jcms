package com.jczx.service;

import com.jczx.domain.TbStudent;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.db.parser.JdbcParser;
import net.atomarrow.services.Service;
import net.atomarrow.util.StringUtil;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 招生
 *
 * @author 于振华
 * @create 2019-11-21 19:38
 */
@Component
public class RecruitService extends Service {
    /**
     * 添加
     *
     * @param student
     * @return
     */
    public ServiceResult addRecruit(TbStudent student) {
        if (StringUtil.isNotBlank(student.getName())&&StringUtil.isNotBlank(student.getLabelIds())&&StringUtil.isNotBlank(student.getStudentPhone())){
            add(student);
            return SUCCESS;
        }
        return error("姓名,意向,电话必须填写");
    }

    /**
     * 修改
     *
     * @param student
     * @return
     */
    public ServiceResult modifyRecruit(TbStudent student) {
        modify(student);
        return SUCCESS;
    }

    /**
     * 删除
     * @param student
     * @return
     */
    public ServiceResult deleteRecruit(TbStudent student) {
        del(student);
        return SUCCESS;
    }

    /**
     * 查询 全部数据
     * @param
     * @param
     * @return
     */
    public List<TbStudent> listRecruit(Pager pager) {
            Conditions conditions = new Conditions(TbStudent.class);
            List<TbStudent> list = getListByPage(conditions, pager);
            System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
            return list;
    }

    /**
     * 查询有分页
     */
    public int getCountRecruit(TbStudent student, Pager pager) {
        Conditions conditions = new Conditions(TbStudent.class);
        conditions.putLIKE("name", student.getName());
        conditions.putLIKE("labelIds", student.getLabelIds());
        List<TbStudent> listByPage = getListByPage(conditions, pager);
        int count = getCount(conditions);
        return count;

    }

    /**
     * 查询当前行数据
     * @param
     * @return
     */
    public TbStudent getStudent(Integer id){
        Conditions conditions = new Conditions(TbStudent.class);
        TbStudent getStudent = getById(TbStudent.class,id);
        System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
        return getStudent;
    }

}
