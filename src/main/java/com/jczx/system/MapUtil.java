package com.jczx.system;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙文举
 * @description
 * @create 2019-11-28 10:55
 */
@Component
public class MapUtil implements CacheInterface {

    private Map<String, Object> map = new HashMap<>();

    /**
     * 根据可以获取value
     *
     * @param key
     * @return
     */
    @Override
    public Object get(String key) {
        return map.get(key);
    }

    /**
     * 设置值
     *
     * @param key
     * @param value
     */
    @Override
    public void set(String key, Object value) {
        map.put(key, value);
    }

    /**
     * 移除某个指定的key
     *
     * @param key
     */
    @Override
    public void remove(String key) {
        map.remove(key);
    }

    /**
     * 清空整个map
     */
    @Override
    public void removeAll() {
        map.clear();
    }
}