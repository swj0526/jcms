package com.jczx.controller;

import com.jczx.domain.TbStudent;
import com.jczx.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@RequestMapping("student")
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * cjw
     *
     * @return
     */
    @RequestMapping("tolist")
    public String tolist() {
        return "student/list";
    }

    /**
     * 查询当前学生信息
     *
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("information")
    public String information(Integer id, Map<String, Object> map) {
        TbStudent student = studentService.getStudent(id);
        map.put("student", student);
        return "student/information";
    }

    @RequestMapping("cost")
    public String cost() {
        return "student/cost";
    }
}


