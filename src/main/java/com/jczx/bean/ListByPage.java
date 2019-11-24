package com.jczx.bean;

import java.util.List;

/**
 * @author 孙文举
 * @description 该bean值用于数据分页
 * @create 2019-11-24 20:10
 */
public class ListByPage  {
    private int count;
    private Object data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}