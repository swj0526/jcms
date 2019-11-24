package com.jczx.controller;


import com.jczx.domain.TbDictionary;
import com.jczx.service.DictionaryService;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ServiceResult add(String name, String  remark,int type) {
        ServiceResult result = dictionaryService.addDictionary(name,remark,type);
       return result;
    }
    @RequestMapping("/list/channel")
    public List<TbDictionary> channel(int type) {
        List<TbDictionary> list = dictionaryService.listChannel(type);
        return list;
    }
}