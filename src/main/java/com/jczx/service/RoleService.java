package com.jczx.service;

import com.jczx.domain.TbRole;
import com.jczx.system.SC;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 孙文举
 * @description 角色的增删改查
 * @create 2019-12-18 10:54
 */
@Component
public class RoleService extends BaseService {
    @Autowired
    private UserService userService;

    /**
     * 新增角色
     *
     * @param role
     * @return
     */
    public ServiceResult addRole(TbRole role) {
        if (StringUtil.isBlank(role.getName())) {
            return error("角色名称不可为空");
        }
        role.setCreateTime(SC.getNowDate());
        role.setOperatorId(SC.getOperatorId());
        add(role);
        return SUCCESS;
    }

    /**
     * 返回角色列表
     *
     * @return
     */
    public List<TbRole> ListRole(Pager pager) {
        Conditions conditions = getConditions();
        int count = getCount(conditions);
        if (pager != null) {
            pager.setDataTotal(count);
        }
        List<TbRole> list = getListByPage(conditions, pager);
        return list;
    }


    /**
     * 修改
     *
     * @param role
     * @return
     */
    public ServiceResult modifyRole(TbRole role) {
        TbRole roleDB = getById(role.getId());
        roleDB.setName(role.getName());
        roleDB.setRemark(role.getRemark());
        modify(roleDB);
        return SUCCESS;
    }

    /**
     * 修改角色权限列表
     *
     * @param functionIds
     * @param roleId
     * @return
     */
    public ServiceResult modifyRoleByFunctionIds(String functionIds, Integer roleId) {
        TbRole role = getById(roleId);
        role.setFunctionIds(functionIds);
        modify(role);
        return SUCCESS;
    }

    /**
     * 删除，判断有两个不可删除的角色
     *
     * @return
     */
    public ServiceResult deleteRole(Integer id) {
        TbRole role = getById(id);
        //先判断是否有两个不可删除的角色
        if (!role.getState()) {
            return error("该角色不可以删除");
        }
        if (userService.hasRoleId(id)) {
            delById(getTableName(), id);
        } else {
            return error("该角色不可删除,该角色下面还有用户");
        }
        return SUCCESS;
    }

    /**
     * 根据id获得角色的权限功能列表
     *
     * @param roleId
     * @return
     */
    public List<Integer> functionList(Integer roleId) {
        TbRole role = getById(roleId);
        List<Integer> list = new ArrayList<>();
        String functionIds = role.getFunctionIds();
        if (functionIds != null) {
            String[] split = functionIds.split(",");
            for (int i = 0; i < split.length; i++) {
                if (!split[i].equals("")) {
                    list.add(Integer.parseInt(split[i]));
                }
            }
        }
        return list;
    }

    @Override
    public String getTableName() {
        return TbRole.class.getSimpleName();
    }

}