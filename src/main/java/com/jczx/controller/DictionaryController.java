package com.jczx.controller;


import com.jczx.bean.ListByPage;
import com.jczx.domain.TbDictionary;
import com.jczx.service.DictionaryService;
import com.jczx.system.OptionInterface;
import net.atomarrow.bean.Pager;
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
        System.out.println("添加方法");
        ServiceResult result = dictionaryService.addDictionary(name,remark,type);
        return result;
    }
    @RequestMapping("/delete")
    public ServiceResult delete(int id) {
        System.out.println("删除方法");
        ServiceResult result = dictionaryService.deleteDictionary(id);
        return result;
    }
    @RequestMapping("/modify")
    public ServiceResult modify(String name, String  remark,int id) {
        System.out.println("修改方法"+id);
        ServiceResult result = dictionaryService.modifyDictionary(name,remark,id);
        return result;
    }
    @RequestMapping("/list/channel")
    public ServiceResult channel( String keywords, int limit, int page) {
        Pager pager = checkPager(limit, page);
        List<TbDictionary> list = dictionaryService.listChannel(TbDictionary.TYPE_CHANNEL,keywords,pager);
        return layuiList(list,pager);
    }
    @RequestMapping("/list/channel/options")
    public List< ? extends OptionInterface> channelOptions( ) { //用静态常量
        List<TbDictionary> list = dictionaryService.listChannel(TbDictionary.TYPE_CHANNEL,null,null);
        return list;
    }
}