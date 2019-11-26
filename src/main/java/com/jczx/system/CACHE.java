package com.jczx.system;


import com.jczx.domain.TbDictionary;
import net.atomarrow.services.Service;
import net.atomarrow.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Random;


/**
 * @author 孙文举
 * @create 2019-11-11 15:08
 */
@Component
public class CACHE {
    @Autowired
    private static RedisTemplate redisTemplate;
    @Autowired
    private static Service service;
    @Autowired
    private static String PREFEX = Math.random() * 10000 + "";

    /**
     * 普通缓存获取
     *
     * @param
     * @return 值
     */
    private static String getKey(String tableName, Integer id) {
        return PREFEX + tableName + id;
    }

    private static TbDictionary getDictionary(Integer dictionaryId) {
        ValueOperations<String, Object> stringStringValueOperations = redisTemplate.opsForValue();
        TbDictionary dictionary = (TbDictionary) stringStringValueOperations.get(getKey(TbDictionary.class.getSimpleName(), dictionaryId));
        if (dictionary != null) {
            return dictionary;
        }
        TbDictionary dictionaryDB = service.getById(TbDictionary.class, dictionaryId);
        if (dictionaryDB == null) {
            return null;
        }
        stringStringValueOperations.set(getKey(TbDictionary.class.getSimpleName(), dictionaryId), dictionaryDB);
        return dictionaryDB;

    }

    /**
     * 返回渠道的名称
     * @param channelId
     * @return
     */
    public static String getChannelName(Integer channelId) {
        if(channelId==null){
            return "";
        }
        TbDictionary dictionary = getDictionary(channelId);
        if (dictionary == null) {
            return "";
        }
        return dictionary.getName();
    }
    /**
     * 返回缴费方式的名称
     * @param paymentMethodId
     * @return
     */
    public static String getPayWayName(Integer paymentMethodId) {
        if(paymentMethodId==null){
            return "";
        }
        TbDictionary dictionary = getDictionary(paymentMethodId);
        System.out.println(paymentMethodId);
        if (dictionary == null) {
            return "";
        }
        return dictionary.getName();
    }
}
