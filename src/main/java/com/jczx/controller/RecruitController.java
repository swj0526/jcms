package com.jczx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * yuzhenhua
 */
@Controller
@RequestMapping("/recruit")
public class RecruitController {
    @RequestMapping("/torecruit")
    public String recruit(){
        return "recruit/recruit";
    }
    @RequestMapping("/tofollow")
    public String follow(){
        return "recruit/follow";
    }
}
