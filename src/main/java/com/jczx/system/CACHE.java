package com.jczx.system;


import com.jczx.domain.TbDictionary;
import com.jczx.service.DictionaryService;
import com.sun.org.apache.regexp.internal.RE;
import net.atomarrow.services.Service;
import net.atomarrow.util.SpringContextUtil;
import net.atomarrow.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Random;


/**
 * @author 孙文举
 * @create 2019-11-11 15:08
 */

public class CACHE {


    public static StringRedisTemplate getRedisTemplate() {
        return SpringContextUtil.getBean(StringRedisTemplate.class);
    }

    private static Service getService() {
        return SpringContextUtil.getBean(DictionaryService.class);
    }

    ;

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

  /*  private static TbDictionary getDictionary(Integer dictionaryId) {
        getRedisTemplate();
        System.out.println("进入方法");
        ValueOperations<String, > stringStringValueOperations = getRedisTemplate().opsForValue();
        System.out.println(224);
        TbDictionary dictionary = (TbDictionary) stringStringValueOperations.get(getKey(TbDictionary.class.getSimpleName(), dictionaryId));

        if (dictionary != null) {
            return dictionary;
        }
        TbDictionary dictionaryDB = getService().getById(TbDictionary.class, dictionaryId);
        System.out.println(dictionaryDB + "++++++++++++++++");
        if (dictionaryDB == null) {
            return null;
        }
        stringStringValueOperations.set(getKey(TbDictionary.class.getSimpleName(), dictionaryId), dictionaryDB);
        return dictionaryDB;

    }*/

    /**
     * 返回渠道的名称
     *
     * @param channelId
     * @return
     */
    public static String getChannelName(Integer channelId) {
        if (channelId == null||channelId==0) {
            return "";
        }
        ValueOperations<String,String> valueOperations = getRedisTemplate().opsForValue();
        String channelName = valueOperations.get(getKey(TbDictionary.class.getSimpleName(), channelId));
        if (StringUtil.isNotBlank(channelName)) {
            return channelName;
        }
        TbDictionary dictionary = getService().getById(TbDictionary.class, channelId);
        if(dictionary==null){
            return "";
        }
        valueOperations.set(getKey(TbDictionary.class.getSimpleName(), channelId),dictionary.getName());
        System.out.println(dictionary.getName());
        return valueOperations.get(getKey(TbDictionary.class.getSimpleName(), channelId));
    }

    /**
     * 返回缴费方式的名称
     *
     * @param paymentMethodId
     * @return
     */
    public static String getPayWayName(Integer paymentMethodId) {
       /* if (paymentMethodId == null) {
            return "";
        }
        TbDictionary dictionary = getDictionary(paymentMethodId);
        System.out.println(paymentMethodId);
        if (dictionary == null) {
            return "";
        }*/
        return "dictionary.getName()";
    }
}
