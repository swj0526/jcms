package com.jczx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

<<<<<<< HEAD
/**
 * @author swj
 * @create 2019-11-13 23:02
 */
@Controller
public class RemindController {
    @RequestMapping("/notSee")
    public String notSee(){
        return "/remind/notSee";
    }
}
=======
@Controller
public class RemindController {
    /**
     * cjw
     * @return
     */
    @RequestMapping("remind")
    public String remind(){
        return "remind/remindPage";
    }
}
>>>>>>> origin/master
