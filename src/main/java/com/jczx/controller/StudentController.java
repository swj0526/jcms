package com.jczx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("student")
@Controller
public class StudentController {
    /**
     * cjw
     * @return
     */
    @RequestMapping("tolist")
    public String tolist(){
        return "student/list";
    }
   /* @RequestMapping("/recruit")
    public String recruit(){
        return "recruit/recruit";
    }*/

}
