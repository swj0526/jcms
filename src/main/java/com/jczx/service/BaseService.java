package com.jczx.service;

import net.atomarrow.db.parser.Conditions;
import net.atomarrow.services.Service;
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
     * @return
     */
    public abstract String getTableName();
    protected Conditions getConditins(){
        return new Conditions(getTableName());
    }
}