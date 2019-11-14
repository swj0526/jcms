package com.jczx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/money")
@Controller
public class MoneyController {
    @RequestMapping("/list")
    public String money(){
        return "money/money";
    }

}
