package com.jczx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IntegralController {
    /**
     * cjw
     * @return
     */
    @RequestMapping("/integral")
    public String integral(){
    return "integral/integralPage";
    }
}
