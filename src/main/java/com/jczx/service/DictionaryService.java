package com.jczx.service;

import com.jczx.domain.TbDictionary;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.db.parser.JdbcParser;
import net.atomarrow.services.Service;
import org.springframework.boot.logging.java.SimpleFormatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 孙文举
 * @description 字典表的增删改查
 * @create 2019-11-22 8:41
 */
@Component
public class DictionaryService extends Service {
    /**
     * 增加字典表
     *
     * @param dictionary
     * @return
     */
    public ServiceResult addDictionary(TbDictionary dictionary) {
        Date date = new Date();
        dictionary.setCreateTime(date);//少字段
        add(dictionary);
        return SUCCESS;
    }

    /**
     * 查找字典表,利用type来返回这一类所有的type的名称
     *
     * @param
     * @return
     */
    public List<TbDictionary> listDictionary(int  type) {
        Conditions conditions = new Conditions(TbDictionary.class);
        conditions.putEW("type",type);
        List<TbDictionary> list = getList(conditions);
        return list;
    }
}