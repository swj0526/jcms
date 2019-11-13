package com.jczx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author swj
 * @create 2019-11-13 23:02
 */
@Controller
public class RemindController {
    @RequestMapping("/noSee")
    public String noSee(){
        return "/remind/noSee";
    }
}