package com.jczx.controller;

import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 孙文举
 * 基础的controller,所有的controller都继承,去调用里面的基础方法
 */
public class BaseController<T> {
    /**
     * @param limit 当前页面显示的条数
     * @param page  显示的当前页
     * @return
     */
    public Pager checkPager(int limit, int page) {
        Pager pager = new Pager();
        pager.setCurrentPage(page);
        pager.setPageSize(limit);
        return pager;
    }

    public ServiceResult layuiList(List<T> list, Pager pager) {
        ServiceResult serviceResult = new ServiceResult(true, list, "", pager);
        return serviceResult;
    }

    public Map<String, Object> uploadeResult(ServiceResult serviceResult) {
        Map<String, Object> map = new HashMap<>();
        if (serviceResult.isSuccess() == true) {
            map.put("code", 0);
        } else {
            map.put("code", -1);
            map.put("msg", serviceResult.getMsg());
        }
        return map;
    }

}
