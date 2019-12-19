package com.jczx.controller;

import com.jczx.domain.TbTeacher;
import com.jczx.service.TeacherService;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.render.Render;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;
import java.util.List;

/**
 * 教职工档案
 *
 * @author 宋家新
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
        return teacherService.addTeacher(teacher);
    }

    @RequestMapping("/modify")
    @ResponseBody
    public ServiceResult modifyTeacher(TbTeacher teacher){
        return teacherService.modifyTeacher(teacher);
    }

    @RequestMapping("/list")
    @ResponseBody
    public ServiceResult teacherList(String keyword,Boolean hasQuit,Integer page,Integer limit){
        Pager pager = checkPager(limit, page);
        List<TbTeacher> list= teacherService.teacherList(keyword,hasQuit,pager);
        return layuiList(list,pager);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ServiceResult deleteTeacher(TbTeacher teacher){
        return teacherService.deleteTeacher(teacher);
    }

    @RequestMapping("/exportExcel")
    @ResponseBody
    public Render doExcel(String name, Boolean hasQuit){
        InputStream inputStream = teacherService.teacherExcel(name,hasQuit);
        return Render.renderFile("老师信息.xls", inputStream);
    }

    @RequestMapping("/exportTemplate")
    @ResponseBody
    public Render exportTemplate(){
        InputStream inputStream = teacherService.excel();
        return Render.renderFile("老师模板.xls", inputStream);
    }

}
