package com.jczx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/integral")
@Controller
public class IntegralController {
    /**
     * cjw
     * @return
     */
    @RequestMapping("/add")
    public String integral(){
    return "integral/integralPage";
    }
    @RequestMapping("/list")
    public String list(){
        return "integral/list";
    }
}
