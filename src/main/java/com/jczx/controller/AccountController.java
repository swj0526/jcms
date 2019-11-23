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
     * 账号列表页面
     * @return
     */
    @RequestMapping("/tolist")
    public String toList(){
        return "account/list";
    }
    /**
     * 角色列表页面
     * @return
     */
    @RequestMapping("/torole")
    public String toRole(){
        return "account/role";
    }
    /**
     * 权限树状图
     * @return
     */
    @RequestMapping("/toprivilege")
    public String toPrivilege(){
        return "account/privilege";
    }
    /**
     * 修改密码
     */
    @RequestMapping("/tomodpassword")
    private String toModPassword(){
        return "account/modPassword";
    }
}