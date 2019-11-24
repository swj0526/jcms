package com.jczx.service;

import com.jczx.domain.TbDictionary;
import com.jczx.system.SC;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.db.parser.JdbcParser;
import net.atomarrow.services.Service;
import org.springframework.boot.logging.java.SimpleFormatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Dictionary;
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
     * @param
     * @return
     */
    public ServiceResult addDictionary(String name, String  remark,int type) {
        TbDictionary dictionary = new  TbDictionary();
        dictionary.setName(name);
        dictionary.setRemark(remark);
        dictionary.setType(type);
        Date date = new Date();
        dictionary.setCreateTime(SC.getNowDate());
        dictionary.setOperatorId(SC.getOperatorId());
        add(dictionary);
        return SUCCESS;
    }

    /**
     * 招生渠道从字典表中取数据
     * @param
     * @return
     */
    public List<TbDictionary> listChannel(int  type) {
        Conditions conditions = new Conditions(TbDictionary.class);
        conditions.putEW("type",type);
        List<TbDictionary> list = getList(conditions);
        return list;
    }
}