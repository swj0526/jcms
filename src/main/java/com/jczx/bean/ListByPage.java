package com.jczx.bean;

import java.util.List;

/**
 * @author 孙文举
 * @description 该bean值用于数据分页
 * @create 2019-11-24 20:10
 */
public class ListByPage<T> {
    private int count;
    private List<T> list;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}