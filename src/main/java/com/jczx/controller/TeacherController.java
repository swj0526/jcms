package com.jczx.controller;

import com.jczx.domain.TbTeacher;
import com.jczx.service.TeacherService;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author cjw
 * @create 2019-11-20 21:34
 */
@RequestMapping("/teacher")
@Component
public class TeacherController extends BaseController{
    @Autowired
    private TeacherService teacherService;


    @RequestMapping("/tolist")
    public String toList() {
        return "/teacher/list";
    }

    @RequestMapping("addTeacher")
    public ServiceResult addTeacher(TbTeacher teacher) {
        ServiceResult add = teacherService.addTeacher(teacher);
        return add;
    }

    @RequestMapping("modifyTeacher")
    public ServiceResult modifyTeacher(TbTeacher teacher){
        ServiceResult modify=teacherService.modifyTeacher(teacher);
        return modify;
    }

    @RequestMapping("list")
    public List<TbTeacher> teacherList(){
        List<TbTeacher> list= teacherService.TeacherList();
        return list;
    }

}
