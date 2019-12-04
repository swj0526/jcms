package com.jczx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 孙文举
 * @description
 * @create 2019-12-03 20:36
 */
@Controller
@RequestMapping("/common")
public class DemoController {

    @RequestMapping("/tomodule")
    public String module() {
        return "/common/module";
    }

    @RequestMapping("/tolist")
    public String list() {
        return "common/list";
    }

}