package com.jczx.service;

import com.jczx.domain.TbRole;
import com.jczx.domain.TbStudent;
import com.jczx.domain.TbTeacher;
import com.jczx.domain.TbUser;
import com.jczx.system.SC;
import jdk.nashorn.internal.objects.NativeUint8Array;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.util.StringUtil;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 孙文举
 * @description 用户表进行操作
 * @create 2019-12-20 0:51
 */
@Component
public class UserService extends BaseService {

    @Autowired
    private StudentService studentService;

    /**
     * 新增账号
     * 学生
     *
     * @param student
     * @return
     */
    public ServiceResult addStudentUser(TbStudent student) {
        TbUser user = new TbUser();
        user.setType(TbUser.TYPE_STUDENT);
        user.setAccountId(student.getId());
        user.setPhone(student.getStudentPhone());
        user.setPassword("123456");
        user.setCreateTime(SC.getNowDate());
        user.setOperatorId(SC.getOperatorId());
        add(user);
        return SUCCESS;

    }

    /**
     * 新增账号
     * 老师
     *
     * @param
     * @return
     */
    public ServiceResult addTeacherUser(TbTeacher teacher) {
        TbUser user = new TbUser();
        user.setType(TbUser.TYPE_TEACHER);
        user.setAccountId(teacher.getId());
        user.setPhone(teacher.getPhone());
        user.setPassword("abcd");
        user.setCreateTime(SC.getNowDate());
        user.setOperatorId(SC.getOperatorId());
        add(user);
        return SUCCESS;

    }

    /**
     * 锁定账号
     *
     * @param user
     * @return
     */
    public ServiceResult cancelUser(TbUser user) {
        user.setEnable(TbUser.TYPE_NO_ENABLE);
        modify(user);
        return SUCCESS;

    }

    /**
     * 激活账号
     *
     * @param user
     * @return
     */
    public ServiceResult activateUser(TbUser user) {
        user.setEnable(TbUser.TYPE_ENABLE);
        modify(user);
        return SUCCESS;

    }

    /**
     * 返回用户列表
     * 学生
     *
     * @return
     */
    public List<TbUser> listStudentUser(Pager pager, String keywords, Integer majorId, Boolean enable) {
        Conditions conditions = getConditions();
        conditions.putEW("type", TbUser.TYPE_STUDENT);
        conditions.putEWIfOk("enable", enable);
        if (StringUtil.isNotBlank(keywords)) {
            conditions.parenthesesStart();
            conditions.putLIKE("name", keywords);
            conditions.or();
            conditions.putLIKE("phone", keywords);
            conditions.parenthesesEnd();
        }
        int count = getCount(conditions);
        pager.setDataTotal(count);
        List<TbUser> list = getListByPage(conditions, pager);
        if (majorId != null) {
            for (TbUser user : list) {
                TbStudent student = studentService.get(user.getAccountId());
                if (student.getMajorId() != majorId) {
                    list.remove(user);
                }
            }
        }
        return list;
    }

    /**
     * 返回角色列表
     * 老师
     *
     * @return
     */
    public List<TbUser> listTeacherUser(Pager pager, String keywords, Boolean enable) {
        Conditions conditions = getConditions();
        conditions.putEW("type", TbUser.TYPE_TEACHER);
        conditions.putEWIfOk("enable", enable);
        if (StringUtil.isNotBlank(keywords)) {
            conditions.parenthesesStart();
            conditions.putLIKE("name", keywords);
            conditions.or();
            conditions.putLIKE("phone", keywords);
            conditions.parenthesesEnd();
        }
        int count = getCount(conditions);
        pager.setDataTotal(count);
        List<TbUser> list = getListByPage(conditions, pager);
        return list;
    }

    /**
     * 重置学生密码
     *
     * @param id
     * @return
     */
    public ServiceResult doReset(Integer id, Integer type) {
        TbUser user = getById(id);
        if (type == 1) {
            user.setPassword("123456");
        } else if (type == 2) {
            user.setPassword("abcd123");
        }
        modify(user);
        return SUCCESS;
    }

    /**
     * 返回角色id列表
     *
     * @return
     */
    public Set<Integer> listRoleIds(Integer id) {
        TbUser user = getById(id);
        Set<Integer> list = new HashSet<>();
        String roleIds = user.getRoleIds();
        String[] split = roleIds.split(",");
        for (int i = 0; i < split.length; i++) {
            if (!split[i].equals("")) {
                list.add(Integer.parseInt(split[i]));
            }
        }
        return list;
    }

    /**
     * 修改角色列表
     *
     * @param roleId
     * @param id
     * @return
     */
    public ServiceResult modifyRoleId(Integer roleId, Integer id) {
        Set<Integer> listRoleIds = listRoleIds(id);
        listRoleIds.add(roleId);
        String roleIds = "";
        for (Integer set : listRoleIds) {
            roleIds = "," + set + roleIds;
        }
        TbUser user = getById(id);
        user.setRoleIds(roleIds);
        modify(user);
        return SUCCESS;
    }

    /**
     * 取消具体角色列表
     *
     * @param roleId
     * @param id
     * @return
     */
    public ServiceResult modifyCancelRoleId(Integer roleId, Integer id) {
        Set<Integer> listRoleIds = listRoleIds(id);
        listRoleIds.remove(roleId);
        String roleIds = "";
        for (Integer set : listRoleIds) {
            roleIds = "," + set + roleIds;
        }
        TbUser user = getById(id);
        user.setRoleIds(roleIds);
        modify(user);
        return SUCCESS;
    }

    /**
     * 根据账号密码获取用户,用于登录检测
     *
     * @param phone
     * @param password
     * @return
     */
    public ServiceResult get(String phone, String password) {
        if (StringUtil.isBlank(phone)) {
            return error("手机号码不可为空!");
        }
        if (StringUtil.isBlank(password)) {
            return error("密码不可为空!");
        }
        Conditions conditions = getConditions();
        conditions.putEW("phone", phone);
        conditions.putEW("password", password);
        TbUser user = getOne(conditions);
        if (user == null) {
            return error("用户名或密码错误!");
        }
        return success(user);
    }

    /**
     * 根据状态,id查找用户表是否有这个教师
     *
     * @return
     */
    public TbUser getUser(Integer accountId, Integer type) {
        Conditions conditions = getConditions();
        conditions.putEW("accountId", accountId);
        conditions.putEW("type", type);
        return getOne(conditions);
    }

    /**
     * 当教职工的状态改为离职之后,则会在用户表里删除该账号
     *
     * @param accountId
     * @param type
     * @return
     */
    public ServiceResult deleteUser(Integer accountId, Integer type) {
        Conditions conditions = getConditions();
        conditions.putEW("accountId", accountId);
        conditions.putEW("type", type);
        delByBatch(conditions);
        return SUCCESS;
    }

    /**
     * 修改用户表的用户名跟手机号码一些基本信息
     * @param type
     * @param name
     * @param phone
     * @param accountId
     * @return
     */
    public ServiceResult modifyUser(Integer type, String name, String phone, Integer accountId) {
        Conditions conditions = getConditions();
        conditions.putEW("accountId", accountId);
        conditions.putEW("type", type);
        TbUser user = getOne(conditions);
        user.setName(name);
        user.setPhone(phone);
        modify(user);
        return SUCCESS;
    }

    @Override
    public String getTableName() {
        return TbUser.class.getSimpleName();
    }
}