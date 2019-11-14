package com.jczx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


/**
 * @author swj
 * @description 所有的提醒管理
 * @create 2019-11-13 23:02
 */
@RequestMapping("/remind")
@Controller
public class RemindController {

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/toPay")
    public String toPay() {

        return "/remind/pay";
    }
}
