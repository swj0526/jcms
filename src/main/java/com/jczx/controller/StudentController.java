package com.jczx.controller;

import com.jczx.domain.TbStudent;
import com.jczx.service.StudentService;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.render.Render;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController extends BaseController {
    @Autowired
    private StudentService studentService;//todo 于  需要查询所有的学生姓名 id 学号

    /**
     * 于振华
     * 学生档案页面
     *
     * @return
     */
    @RequestMapping("/tolist")
    public String tolist() {
        return "student/list";
    }

    /**
     * 查询入学学生的全部信息
     *
     * @param *     @param page
     * @param limit
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public ServiceResult listStudent(String keywords, String admissionData, Integer studentState, Integer page, Integer limit) {
        Pager pager = checkPager(limit, page);
        List<TbStudent> studentList = studentService.listStudent(keywords, admissionData, studentState, pager);
        return layuiList(studentList, pager);
    }

    /**
     * 查询当前学生信息
     *
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("/information")
    public String getInformation(Integer id, Map<String, Object> map) {
        TbStudent student = studentService.getById(id);
        map.put("student", student);
        /*if (student.getAdmissionData()!=null){
            map.put("admissionData",student.getAdmissionData().toString());
        }*/
        return "/student/information";
    }

    /**
     * 修改学生的基本信息页面
     *
     * @return
     */
    @RequestMapping("/tostudent")
    public String toModify(Integer id, Map<String, Object> map) {
        TbStudent student = studentService.getById(id);
        map.put("student", student);
        if (student.getAdmissionData() != null) {
            map.put("admissionData", student.getAdmissionData().toString());
        }

        return "/student/addstudent";
    }

    /**
     * 修改学生基本信息
     *
     * @param student
     * @return
     */
    @RequestMapping("/modify")
    @ResponseBody
    public ServiceResult modifyStudent(TbStudent student) {
        ServiceResult result = studentService.modifyStudent(student);
        return result;


    }

    @RequestMapping("/modifyOne")
    @ResponseBody
    public ServiceResult modifyOne(TbStudent student) {
        ServiceResult result = studentService.modifyOne(student);
        return result;
    }

    /**
     * 导出学生信息
     *
     * @param keywords
     * @param
     * @param
     * @param
     * @param
     * @return
     */
    @RequestMapping("/exportexcel")
    @ResponseBody
    public Render excel(String keywords, String admissionData, Integer studentState) {
        InputStream inputStream = studentService.studentExcel(keywords, admissionData, studentState, null);
        return Render.renderFile("学生信息表.xls", inputStream);
    }

}


