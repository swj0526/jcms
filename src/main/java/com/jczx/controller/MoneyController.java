package com.jczx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 丛枭钰
 * @description 缴费页面
 * @create 2019-11-14 14:29
 */
@RequestMapping("/money")
@Controller
public class MoneyController {
    /**
     * 缴费列表
     *
     * @return
     */
    @RequestMapping("/list")
    public String list() {
        return "money/list";
    }

}
