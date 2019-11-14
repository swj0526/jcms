package com.jczx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    /**
     * cjw
     * @return
     */
    @RequestMapping("student")
    public String student(){
        return "student/studentPage";
    }
   /* @RequestMapping("/recruit")
    public String recruit(){
        return "recruit/recruit";
    }*/

}
