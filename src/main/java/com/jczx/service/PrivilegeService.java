package com.jczx.service;

import com.jczx.domain.TbFunction;
import net.atomarrow.db.parser.Conditions;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 孙文举
 * @description 功能选项的增删改查
 * @create 2019-12-24 18:31
 */
@Component
public class PrivilegeService extends BaseService {
    /**
     * 返回权限功能列表
     *
     * @return
     */
    public List<TbFunction> listFunctions() {
        Conditions conditions = getConditions();
        return getList(conditions);
    }


    @Override
    public String getTableName() {
        return TbFunction.class.getSimpleName();
    }
}