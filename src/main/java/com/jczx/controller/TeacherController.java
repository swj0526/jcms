package com.jczx.controller;

import com.jczx.domain.TbTeacher;
import com.jczx.service.TeacherService;
import net.atomarrow.bean.Pager;
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
    @ResponseBody
    public ServiceResult addTeacher(TbTeacher teacher) {
        ServiceResult add = teacherService.addTeacher(teacher);
        System.out.println("页面"+add.isSuccess());
        return add;
    }

    @RequestMapping("/modify")
    @ResponseBody
    public ServiceResult modifyTeacher(TbTeacher teacher){
        ServiceResult modify=teacherService.modifyTeacher(teacher);
        return modify;
    }

    @RequestMapping("/list")
    @ResponseBody
    public ServiceResult teacherList(String name, boolean hasQuit, int page, int limit){
        Pager pager = checkPager(limit, page);
        List<TbTeacher> list= teacherService.teacherList(name,hasQuit,pager);
        System.out.println(name);
        System.out.println(hasQuit);
        return layuiList(list,pager);
    }

    @RequestMapping("/delete")
    public ServiceResult deleteTeacher(TbTeacher teacher){
        ServiceResult delete= teacherService.deleteTeacher(teacher);
        return delete;
    }

    /*@RequestMapping("/doExcel")
    @ResponseBody
    public Render doExcel(TbTeacher teacher,PageBean pageBean){
        InputStream inputStream = teacherService.teacherExcel(teacher,pageBean);
        return Render.renderFile("老师信息.xls", inputStream);
    }*/

}
