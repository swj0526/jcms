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

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * @author 孙文举
 * @create 2019-11-11 15:08
 */

public class CACHE {
    /**
     * 现在使用的是集map实现类
     *
     * @return
     */
    private static CacheInterface getUtil() {
        return SpringContextUtil.getBean(MapUtil.class);
    }

    /**
     * 字典表的service,此处需要具体的service
     *
     * @return
     */
    private static Service getDictionaryService() {
        return SpringContextUtil.getBean(DictionaryService.class);
    }

    private static String PREFEX = Math.random() * 10000 + "";

    /**
     * 获取key的名称
     *
     * @param tableName
     * @param id
     * @return
     */
    private static String getKey(String tableName, Integer id) {
        return PREFEX + tableName + id;
    }


    /**
     * 字典表对象
     *
     * @param id
     * @return
     */
    private static TbDictionary getDictionary(Integer id) {
        if (id == 0 || id == null) {
            return null;
        }
        TbDictionary dictionary = (TbDictionary) getUtil().get(getKey(TbDictionary.class.getSimpleName(), id));
        if (dictionary != null) {
            return dictionary;
        }
        TbDictionary dictionaryDB = getDictionaryService().getById(TbDictionary.class.getSimpleName(), id);
        if (dictionaryDB == null) {
            return null;
        }
        getUtil().set(getKey(TbDictionary.class.getSimpleName(), id), dictionaryDB);
        return dictionaryDB;
    }

    /**
     * 渠道的名称
     * @param channelId
     * @return
     */
    public static String getChannelName(Integer channelId) {
        if (channelId == null || channelId == 0) {
            return "";
        }
        TbDictionary dictionary = getDictionary(channelId);
        if(dictionary==null){
            return "";
        }
        return dictionary.getName();
    }
    /**
     * 缴费类型
     */
    public static String getTypeName(Integer typeId){
        if (typeId == null || typeId == 0) {
            return "";
        }
        TbDictionary dictionary = getDictionary(typeId);
        if(dictionary==null){
            return "";
        }
        return dictionary.getName();
    }
    /**
     * 缴费方式
     */
    public static String getPaymentMethodName(Integer paymentMethodId){
        if (paymentMethodId == null || paymentMethodId == 0) {
            return "";
        }
        TbDictionary dictionary = getDictionary(paymentMethodId);
        if(dictionary==null){
            return "";
        }
        return dictionary.getName();
    }

    /**
     * 学年
     * @param semesterId
     * @return
     */
    public static String getSemesterName(Integer semesterId){
        if (semesterId == null || semesterId == 0) {
            return "";
        }
        TbDictionary dictionary = getDictionary(semesterId);
        if(dictionary==null){
            return "";
        }
        return dictionary.getName();
    }
    /**
     * 文章类型
     */
    public static String getArticleType(){
        return "";
    }




















    /* *//**
     * 返回渠道的名称
     *
     * @param channelId
     * @return
     *//*
     */

    /*
     *//**
     * 缴费类型
     *
     * @param typeId
     * @return
     *//*
    public static String getTypeName(Integer typeId) {
        if (typeId == null || typeId == 0) {
            return "";
        }
        ValueOperations<String, String> valueOperations = getRedisTemplate().opsForValue();
        String typeName = valueOperations.get(getKey(TbDictionary.class.getSimpleName(), typeId));
        if (StringUtil.isNotBlank(typeName)) {
            return typeName;
        }
        TbDictionary dictionary = getDictionaryService().getById(TbDictionary.class, typeId);
        if (dictionary == null) {
            return "";
        }
        valueOperations.set(getKey(TbDictionary.class.getSimpleName(), typeId), dictionary.getName());
        System.out.println(dictionary.getName());
        return valueOperations.get(getKey(TbDictionary.class.getSimpleName(), typeId));
    }

    *//**
     * 缴费方式
     *
     * @param paymentMethodId
     * @return
     *//*
    public static String getPaymentMethodName(Integer paymentMethodId) {
        if (paymentMethodId == null || paymentMethodId == 0) {
            return "";
        }
        ValueOperations<String, String> valueOperations = getRedisTemplate().opsForValue();
        String methodeName = valueOperations.get(getKey(TbDictionary.class.getSimpleName(), paymentMethodId));
        if (StringUtil.isNotBlank(methodeName)) {
            return methodeName;
        }
        TbDictionary dictionary = getDictionaryService().getById(TbDictionary.class, paymentMethodId);
        if (dictionary == null) {
            return "";
        }
        valueOperations.set(getKey(TbDictionary.class.getSimpleName(), paymentMethodId), dictionary.getName());
        System.out.println(dictionary.getName());
        return valueOperations.get(getKey(TbDictionary.class.getSimpleName(), paymentMethodId));
    }

    public static String getSemesterName(Integer semesterId) {
        if (semesterId == null || semesterId == 0) {
            return "";
        }
        ValueOperations<String, String> valueOperations = getRedisTemplate().opsForValue();
        String semestereName = valueOperations.get(getKey(TbDictionary.class.getSimpleName(), semesterId));
        if (StringUtil.isNotBlank(semestereName)) {
            return semestereName;
        }
        TbDictionary dictionary = getDictionaryService().getById(TbDictionary.class, semesterId);
        if (dictionary == null) {
            return "";
        }
        valueOperations.set(getKey(TbDictionary.class.getSimpleName(), semesterId), dictionary.getName());
        System.out.println(dictionary.getName());
        return valueOperations.get(getKey(TbDictionary.class.getSimpleName(), semesterId));
    }*/
}
