package com.jczx.service;

import com.jczx.domain.TbDictionary;
import com.jczx.domain.TbStudent;
import com.jczx.system.SC;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.regexp.internal.RE;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.db.parser.JdbcParser;
import net.atomarrow.services.Service;
import net.atomarrow.util.StringUtil;
import org.springframework.boot.logging.java.SimpleFormatter;
import org.springframework.stereotype.Component;

import javax.naming.Name;
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
    public ServiceResult addDictionary(String name, String remark, int type) {
        TbDictionary dictionary = new TbDictionary();
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
     * 修改字典信息
     *
     * @param name
     * @param remark
     * @param id
     * @return
     */
    public ServiceResult modifyDictionary(String name, String remark, int id) {
        TbDictionary dictionary = getById(TbDictionary.class, id);
        dictionary.setName(name);
        dictionary.setRemark(remark);
        int modify = modify(dictionary);
        return SUCCESS;
    }

    /**
     *删除渠道
     * @param id
     * @return
     */
    public ServiceResult deleteDictionary(int id) {
        Conditions conditions = new Conditions(TbStudent.class);
        conditions.putEW("channelId",id);
        List<TbStudent> list = getList(conditions);
        if(list.size()==0){
            return error("不可删除,该标签已被使用!");
        }
        int del = delById(TbDictionary.class, id);
        return SUCCESS;
    }
    /**
     * 招生渠道从字典表中取数据
     *
     * @param
     * @return
     */
    public List<TbDictionary> listChannel(int type, String keywords, Pager pager) {
        Conditions conditions = new Conditions(TbDictionary.class);
        conditions.putEW("type", type);
        if (StringUtil.isNotBlank(keywords)) {
            conditions.parenthesesStart();
            conditions.putLIKEIfOK("name", keywords);
            conditions.or();
            conditions.putLIKEIfOK("remark", keywords);
            conditions.parenthesesEnd();
        }


        List<TbDictionary> list = getListByPage(conditions, pager);
        System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
        return list;
    }

    /**
     * 获取总数
     *
     * @return
     */
    public int count(int type, String keywords) {
        Conditions conditions = new Conditions(TbDictionary.class);
        conditions.putEW("type", type);
        if (StringUtil.isNotBlank(keywords)) {
            conditions.parenthesesStart();
            conditions.putLIKEIfOK("name", keywords);
            conditions.or();
            conditions.putLIKEIfOK("remark", keywords);
            conditions.parenthesesEnd();
        }

        int count = getCount(conditions);
        return count;

    }


}