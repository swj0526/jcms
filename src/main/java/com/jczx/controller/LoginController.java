package com.jczx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * 登录
 * @author swj
 *
 * @create 2019-11-13 16:09
 */
@Controller
public class LoginController {


    /**
     * 登录
     * @return
     */
    @RequestMapping("/login")
    private String login(){
        return "login/to";
    }


}