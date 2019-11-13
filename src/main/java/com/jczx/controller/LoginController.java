package com.jczx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author swj
 * @create 2019-11-13 16:09
 */
@Controller
public class LoginController {
    @RequestMapping("/home123456")
    private String home(){
        return "home";
    }
}