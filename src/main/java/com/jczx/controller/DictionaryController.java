package com.jczx.controller;


import com.jczx.bean.ResultBean;
import com.jczx.domain.TbDictionary;
import com.jczx.service.DictionaryService;
import com.sun.org.apache.regexp.internal.RE;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 孙文举
 * @description
 * @create 2019-11-22 9:19
 */
@RequestMapping("/dictionary")
@RestController
public class DictionaryController extends BaseController {
    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping("/add")
    public ServiceResult add(TbDictionary dictionary) {
        ServiceResult result = dictionaryService.addDictionary(dictionary);
       return result;
    }
    @RequestMapping("/list/channel")
    public List<TbDictionary> channel(int type) {
        List<TbDictionary> list = dictionaryService.listDictionary(type);
        System.out.println(list);
        return list;
    }
}