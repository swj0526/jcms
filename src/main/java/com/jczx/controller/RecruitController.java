package com.jczx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecruitController {
    @RequestMapping("/recruit")
    public String recruit(){
        return "recruit/remindPage";
    }
}