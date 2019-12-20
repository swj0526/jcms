package com.jczx.controller;

import com.jczx.domain.TbRole;
import com.jczx.service.RoleService;
import com.sun.org.apache.regexp.internal.RE;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author swj
 * @description 账号管理页面
 * @create 2019-11-14 14:29
 */
@RequestMapping("/account")
@Controller
public class AccountController extends BaseController {
    @Autowired
    private RoleService roleService;

    /**
     * 账号列表页面
     *
     * @return
     */
    @RequestMapping("/tolist")
    public String toList() {
        return "account/list";
    }

    /**
     * 角色列表页面
     *
     * @return
     */
    @RequestMapping("/torole")
    public String toRole() {
        return "account/role";
    }

    /**
     * 权限树状图
     *
     * @return
     */
    @RequestMapping("/toprivilege")
    public String toPrivilege() {
        return "account/privilege";
    }

    /**
     * 修改密码
     */
    @RequestMapping("/tomodpassword")
    private String toModPassword() {
        return "account/modPassword";
    }

    /**
     * 新增角色
     *
     * @param role
     * @return
     */
    @RequestMapping("/role/add")
    @ResponseBody
    private ServiceResult roleAdd(TbRole role) {
        return roleService.addRole(role);
    }

    /**
     * 角色列表
     *
     * @return
     */
    @RequestMapping("/role/list")
    @ResponseBody
    private ServiceResult list(Integer limit, Integer page) {
        Pager pager = checkPager(limit, page);
        List<TbRole> list = roleService.ListRole(pager);
        return layuiList(list, pager);

    }

    @RequestMapping("/modify")
    @ResponseBody
    private ServiceResult modify(TbRole role) {
        return roleService.modifyRole(role);
    }
    @RequestMapping("/delete")
    @ResponseBody
    private ServiceResult delete(Integer id) {
        return roleService.deleteRole(id);
    }



}