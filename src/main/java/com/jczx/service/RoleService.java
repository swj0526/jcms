package com.jczx.service;

import com.jczx.domain.TbRole;
import com.jczx.domain.TbUser;
import com.jczx.system.SC;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.util.StringUtil;
import org.springframework.stereotype.Component;

import javax.management.relation.Role;
import java.util.List;

/**
 * @author 孙文举
 * @description 角色的增删改查
 * @create 2019-12-18 10:54
 */
@Component
public class RoleService extends BaseService {
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
     * 删除
     *
     * @return
     */
    public ServiceResult deleteRole(Integer id) {
        delById(getTableName(), id);
        //TODO 要判断下面有没有账号
        return SUCCESS;
    }

    @Override
    public String getTableName() {
        return TbRole.class.getSimpleName();
    }

}