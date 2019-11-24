package com.jczx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 于振华
 * @create 2019-11-24 19:25
 */
@Controller
@RequestMapping("/internship")
public class InternshipController {
    @RequestMapping("/to")
    public  String toInternship(){
        return "/recruit/internship";
    }
}
