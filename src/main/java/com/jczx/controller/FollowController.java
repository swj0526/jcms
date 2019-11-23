package com.jczx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 于振华
 * @create 2019-11-22 15:58
 */
@Controller
@RequestMapping("/follow")
public class FollowController {
    /**
     * 到渠道页面
     ******************
     * @return
     */
    @RequestMapping("/to")
    public String follow() {
        return "recruit/follow";
    }
}
