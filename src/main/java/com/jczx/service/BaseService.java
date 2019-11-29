package com.jczx.service;

import net.atomarrow.db.parser.Conditions;
import net.atomarrow.services.Service;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Component;

/**
 * @author 孙文举
 * @description baseservice.所有的service继承
 * @create 2019-11-22 8:41
 */
@Component
public abstract class BaseService extends Service {
    /**
     * 返回表名
     *
     * @return
     */
    public abstract String getTableName();

    /**
     * 返回conditons条件对象
     *
     * @return
     */
    protected Conditions Conditions() {
        return new Conditions(getTableName());
    }

    /**
     * 可在controller中直接使用,不用在二次封装
     * @param id
     * @return
     */
    public T getById(Integer id) {
        return getById(getTableName(), id);
    }
}