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
     * 账号列表选项卡总和页面
     * @return
     */
    @RequestMapping("/toTab")
    public String toTab(){
        return "account/tab";
    }
    /**
     * 学生账号管理列表
     * @return
     */
    @RequestMapping("/toListStudent")
    public String toListStudent(){
        return "account/listStudent";
    }
    /**
     * 职工账号管理列表
     * @return
     */
    @RequestMapping("/toListStaff")
    public String toListStaff(){
        return "account/listStaff";
    }
}