package com.jczx.controller;

import com.jczx.bean.PageBean;
import com.jczx.bean.ResultBean;
import com.jczx.domain.TbTeacher;
import com.jczx.service.TeacherService;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author
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

    @RequestMapping("/add")
    public ServiceResult addTeacher(TbTeacher teacher) {
        ServiceResult add = teacherService.addTeacher(teacher);
        return add;
    }

    @RequestMapping("/modify")
    public ServiceResult modifyTeacher(TbTeacher teacher){
        ServiceResult modify=teacherService.modifyTeacher(teacher);
        return modify;
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResultBean teacherList(TbTeacher teacher,PageBean pageBean){
        List<TbTeacher> list= teacherService.teacherList(teacher,pageBean);
        int count=teacherService.count();
        return success(list,count);
    }

    /*@RequestMapping("/doExcel")
    @ResponseBody
    public Render doExcel(TbTeacher teacher,PageBean pageBean){
        InputStream inputStream = teacherService.teacherExcel(teacher,pageBean);
        return Render.renderFile("老师信息.xls", inputStream);
    }*/

}
