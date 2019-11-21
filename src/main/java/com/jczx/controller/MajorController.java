package com.jczx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cjw
 * @create 2019-11-20 22:22
 */
@RequestMapping("major")
@Controller
public class MajorController {
    @RequestMapping("toList")
    public String toList(){
        return "/major/list";
    }
    @RequestMapping("information")
    public String information(){
        return "/major/information";
    }
}
