package com.jczx.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cjw
 * @create 2019-11-20 21:34
 */
@RequestMapping("/teacher")
@Component
public class TeacherController {
    @RequestMapping("/tolist")
    public String toList(){
        return "/teacher/list";
    }
}
