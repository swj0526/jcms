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
    public ServiceResult addTeacher(TbTeacher teacher) {//#todo 宋

        ServiceResult add = teacherService.addTeacher(teacher);
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
    public ServiceResult teacherList(String keyword,Boolean hasQuit,Integer page,Integer limit){
        Pager pager = checkPager(limit, page);
        List<TbTeacher> list= teacherService.teacherList(keyword,hasQuit,pager);
        return layuiList(list,pager);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ServiceResult deleteTeacher(TbTeacher teacher){
        ServiceResult delete= teacherService.deleteTeacher(teacher);
        return delete;
    }

    @RequestMapping("/doExcel")
    @ResponseBody
    public Render doExcel(String name, Boolean hasQuit){
        Pager pager = new Pager();//#todo 宋
        pager.setPageSize(100000);
        pager.setCurrentPage(1);
        InputStream inputStream = teacherService.teacherExcel(name,hasQuit,pager);
        return Render.renderFile("老师信息.xls", inputStream);
    }

    @RequestMapping("/exporttemplate")
    @ResponseBody
    public Render exportTemplate(){//#todo 宋
        InputStream inputStream = teacherService.excel();
        return Render.renderFile("老师模板.xls", inputStream);
    }

}
