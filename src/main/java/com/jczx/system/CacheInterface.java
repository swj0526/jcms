package com.jczx.system;

/**
 * @author 孙文举
 * @description
 * @create 2019-11-28 11:31
 */
public interface CacheInterface {
    //获取
    public Object get(String key);

    //设置
    public void set(String key, Object value);

    //移除某个
    public void remove(String key);

    //移除全部
    public void removeAll();
}
