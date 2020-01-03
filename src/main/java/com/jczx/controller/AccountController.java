package com.jczx.controller;

import com.jczx.domain.TbFunction;
import com.jczx.domain.TbRole;
import com.jczx.domain.TbUser;
import com.jczx.service.PrivilegeService;
import com.jczx.service.RoleService;
import com.jczx.service.UserService;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
    @Autowired
    private PrivilegeService privilegeService;
    @Autowired
    private UserService userService;


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
    public String toPrivilege(Map<String, Object> map, Integer roleId) {
        List<TbFunction> list = privilegeService.listFunctions();
        map.put("list", list);
        map.put("roleId", roleId);
        List<Integer> functionList = roleService.functionList(roleId);// 角色权限列表
        map.put("functionList", functionList);
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
     * 修改密码
     */
    @RequestMapping("/tosetrole")
    private String toSetRole(Map<String, Object> map, Integer id) {
        List<TbRole> list = roleService.ListRole(null);
        Set<Integer> listRoleId = userService.listRoleIds(id);
        map.put("id", id);
        map.put("list", list);
        map.put("listRoleId", listRoleId);
        return "account/setRole";
    }

    /**
     * 新增角色
     *
     * @param role
     * @return
     */
    @RequestMapping("/role/add")
    @ResponseBody
    private ServiceResult addRole(TbRole role) {
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

    /**
     * 修改角色
     *
     * @param role
     * @return
     */
    @RequestMapping("/modify")
    @ResponseBody
    private ServiceResult modifyRole(TbRole role) {
        return roleService.modifyRole(role);
    }

    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    private ServiceResult deleteRole(Integer id) {
        return roleService.deleteRole(id);
    }

    /**
     * 新增用户
     *
     * @param id
     * @return
     */
    @RequestMapping("/user/activate")
    @ResponseBody
    private ServiceResult activateUser(Integer id) {
        TbUser user = userService.getById(id);
        return userService.activateUser(user);
    }

    /**
     * 锁定用户
     *
     * @param id
     * @return
     */
    @RequestMapping("/user/cancel")
    @ResponseBody
    private ServiceResult cancelUser(Integer id) {
        TbUser user = userService.getById(id);
        return userService.cancelUser(user);
    }

    /**
     * 返回学生用户表
     *
     * @param keywords
     * @param limit
     * @param page
     * @return
     */
    @RequestMapping("/student/list")
    @ResponseBody
    private ServiceResult studentList(String keywords, Integer limit, Integer page,Integer majorId,Boolean enable) {
        Pager pager = checkPager(limit, page);
        List<TbUser> list = userService.listStudentUser(pager, keywords,majorId,enable);
        return layuiList(list, pager);
    }

    /**
     * 返回教师用户表
     *
     * @param keywords
     * @param limit
     * @param page
     * @return
     */
    @RequestMapping("/teacher/list")
    @ResponseBody
    private ServiceResult teacherList(String keywords, Integer limit, Integer page,Boolean enable) {
        Pager pager = checkPager(limit, page);
        List<TbUser> list = userService.listTeacherUser(pager, keywords,enable);
        return layuiList(list, pager);
    }

    /**
     * 重置学生密码
     *
     * @param id
     * @return
     */
    @RequestMapping("/reset")
    @ResponseBody
    private ServiceResult doReset(Integer id, Integer type) {
        return userService.doReset(id, type);
    }

    /**
     * 修改角色列表
     *
     * @param roleId
     * @param id
     * @return
     */
    @RequestMapping("/modifyroleid")
    @ResponseBody
    private ServiceResult modifyRoleId(Integer roleId, Integer id) {
        return userService.modifyRoleId(roleId, id);

    }

    /**
     * 取消单个角色
     *
     * @param roleId
     * @param id
     * @return
     */
    @RequestMapping("/cancelroleid")
    @ResponseBody
    private ServiceResult cancelRoleId(Integer roleId, Integer id) {
        return userService.modifyCancelRoleId(roleId, id);

    }

    /**
     * 修改角色的权限列表
     *
     * @param functionIds
     * @param roleId
     * @return
     */
    @RequestMapping("/rolepermission")
    @ResponseBody
    private ServiceResult rolePermission(String functionIds, Integer roleId) {
        return roleService.modifyRoleByFunctionIds(functionIds, roleId);
    }
}