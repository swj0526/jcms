package com.jczx.service;

import com.jczx.domain.TbStudent;
import com.jczx.system.SC;
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
        student.setCreateTime(SC.getNowDate());//操作时间
        student.setOperatorId(SC.getOperatorId());//操作人
        Conditions conditions = new Conditions(TbStudent.class);
        conditions.putEW("studentPhone", student.getStudentPhone());
        conditions.or();
        conditions.putEW("motherPhone", student.getMotherPhone());
        List<Object> listRecruit = getList(conditions);
        if (listRecruit.size() != 0) {
            return error("学生电话,母亲电话有重复");
        }
        if (StringUtil.isNotBlank(student.getName()) && StringUtil.isNotBlank(student.getLabelIds())
                && StringUtil.isNotBlank(student.getStudentPhone())) {
            add(student);
            return SUCCESS;
        }
        return error("姓名,意向,学生电话必须填写");
    }
    /**
     * 查询当前行数据将数,据赋值到页面上,该方法配合修改
     * @param
     * @return
     */
    public TbStudent getStudent(Integer id) {
        Conditions conditions = new Conditions(TbStudent.class);
        TbStudent getStudent = getById(TbStudent.class, id);
        System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
        return getStudent;
    }
    /**
     * 修改
     * @param student
     * @return
     */
    public ServiceResult modifyRecruit(TbStudent student) {
        student.setCreateTime(SC.getNowDate());//操作时间
        student.setOperatorId(SC.getOperatorId());//操作人
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
     * 查询
     */
    public List<TbStudent> listRecruit(String name, String labelIds,String sex, Pager pager) { //模糊关键字keywords查询用or

        System.out.println("条件");
        Conditions conditions = new Conditions(TbStudent.class);
        conditions.parenthesesStart();
        conditions.putLIKE("name", name);//判断是否为空
        //conditions.putLIKEIfOK("name", name);
        conditions.or();
        conditions.putLIKE("labelIds", labelIds);
        conditions.parenthesesEnd();
        if (StringUtil.isNotBlank(sex)){

            conditions.putEW("sex", sex);
        }
      /*  conditions.or();//跟踪时间在详情表
        conditions.putLIKE("followTime",followTime);*/
        pager.setDataTotal(getCount(conditions));//调用分页之前给设置总条数
        List<TbStudent> listStudent = getListByPage(conditions, pager);

        System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
        return listStudent;

    }
    /**
     * 分页总数
     */
    public int getCount(String name, String labelIds,String sex, Pager pager){
        if (StringUtil.isBlank(name)&&StringUtil.isBlank(labelIds)&&StringUtil.isBlank(sex)){
            System.out.println("查询全部");
            Conditions conditions = new Conditions(TbStudent.class);
            int count = getCount(conditions);
            return count;
        }
        Conditions conditions = new Conditions(TbStudent.class);
        conditions.parenthesesStart();
        conditions.putLIKE("name", name);
        conditions.or();
        conditions.putLIKE("labelIds", labelIds);
        conditions.parenthesesEnd();
        if (StringUtil.isNotBlank(sex)){

            conditions.putEW("sex", sex);
        }

        List<TbStudent> listStudent = getListByPage(conditions, pager);
        int count = getCount(conditions);
        System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
        return count;
    }



}
