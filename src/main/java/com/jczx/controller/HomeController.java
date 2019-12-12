package com.jczx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author swj
 * @description home首页数据统计
 * @create 2019-11-14 13:55
 */
@RequestMapping("/home")
@Controller
public class HomeController extends BaseController {

    @RequestMapping("/main")
    private String mianHome() {
        return "/home/main";
    }

    @RequestMapping("/context")
    private String context() {
        return "/home/context";
    }
}