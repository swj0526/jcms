package com.jczx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/article")
@Controller
public class ArticleController {
    @RequestMapping("/dispatch")
    public String funds(){
        return "article/dispatch";
    }

    @RequestMapping("/list")
    public String leave(){
        return "article/list";
    }

}
