package com.jczx.service;

import com.jczx.domain.TbDictionary;
import com.jczx.domain.TbStudent;
import com.jczx.system.SC;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.db.parser.JdbcParser;
import net.atomarrow.services.Service;
import net.atomarrow.util.StringUtil;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

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
}