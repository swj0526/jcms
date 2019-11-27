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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        Date date = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("YYYY-MM-dd");
        String time = dateformat.format(date);
        Date createTime = null;
        try {
            createTime = dateformat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        teacher.setCreateTime(createTime);
        ServiceResult add = teacherService.addTeacher(teacher);
        return add;
    }

    @RequestMapping("/modify")
    @ResponseBody
    public ServiceResult modifyTeacher(TbTeacher teacher){
        System.out.println(teacher.getName());
        System.out.println(teacher.getPhone());
        System.out.println(teacher.getHasQuit());

        ServiceResult modify=teacherService.modifyTeacher(teacher);
        return modify;
    }

    @RequestMapping("/list")
    @ResponseBody
    public ServiceResult teacherList(String name,boolean hasQuit, int page, int limit){
        Pager pager = checkPager(limit, page);
        List<TbTeacher> list= teacherService.teacherList(name,hasQuit,pager);
        System.out.println(name);
        System.out.println(hasQuit);
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
    public Render doExcel(String name,boolean hasQuit){
        Pager pager = new Pager();
        pager.setPageSize(100000);
        pager.setCurrentPage(1);
        InputStream inputStream = teacherService.teacherExcel(name,hasQuit,pager);
        return Render.renderFile("老师信息.xls", inputStream);
    }

}
