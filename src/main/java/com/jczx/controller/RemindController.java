package com.jczx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RemindController {
    /**
     * cjw
     * @return
     */
    @RequestMapping("remind")
    public String remind(){
        return "remind/remindPage";
    }
}
