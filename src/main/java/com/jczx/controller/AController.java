package com.jczx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cjw
 * @create 2019-11-20 13:54
 */
@Controller
public class AController {
    @RequestMapping("/a")
    public String xiaoxixi(){
        return "xiaoixiController";
    }
}
