package com.jczx.service;

import com.jczx.domain.TbStudent;
import com.jczx.domain.TbTeacher;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.services.Service;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 老师
 * @author 宋家新
 * @create 2019-11-21 13:30
 */
@Component
public class TeacherService  extends Service {
    /**
     * 添加老师
     * @param teacher
     * @return
     */
    public ServiceResult addTeacher(TbTeacher teacher) {
        add(teacher);
        return SUCCSS;
    }

    /**
     * 修改老师信息
     * @param teacher
     * @return
     */
    public ServiceResult modifyTeacher(TbTeacher teacher){
        modify(teacher);
        return SUCCSS;
    }

    /**
     * 查找老师表所有信息
     * @return
     */
    public List<TbTeacher> TeacherList(){
        Conditions conditions = new Conditions(TbTeacher.class);
        List<TbTeacher> teacher = getList(conditions);
        return teacher;
    }

    /**
     * 根据老师姓名查找Id
     * @param name
     * @return
     */
    public int getTeacherId(String name){
        Conditions conditions = new Conditions(TbTeacher.class);
        conditions.putEW("name",name);
        TbStudent get=getOne(conditions);
        int id=get.getId();
        return id;
    }

}
