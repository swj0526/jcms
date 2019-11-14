package com.jczx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author swj
 * @description 账号管理页面
 * @create 2019-11-14 14:29
 */
@RequestMapping("/account")
@Controller
public class AccountController {
    /**
     * 账号管理列表
     * @return
     */
    @RequestMapping("/toList")
    public String toList(){
        return "account/list";
    }
}