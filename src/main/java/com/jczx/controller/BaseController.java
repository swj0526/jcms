package com.jczx.controller;

import com.jczx.bean.ResultBean;
import net.atomarrow.bean.Pager;


/**
 * 孙文举
 * 基础的controller,所有的controller都继承,去调用里面的基础方法
 */
public class BaseController{
    /**
     *
     * @param limit 当前页面显示的条数
     * @param page 显示的当前页
     * @return
     */
    public Pager checkPager(int limit,int page){
        Pager pager = new Pager();
        pager.setCurrentPage(page);
        pager.setPageSize(limit);
            return pager;
    }
}