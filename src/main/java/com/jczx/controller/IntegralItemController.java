package com.jczx.controller;

import com.jczx.domain.TbIntegralItem;
import com.jczx.service.IntegralItemService;
import com.jczx.system.SC;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 丛枭钰
 * @create 2019-11-29 13:38
 */
@RequestMapping("/integralitem")
@Controller
public class IntegralItemController extends BaseController {
    @Autowired
    private IntegralItemService integralItemService;

    /**
     * 跳转列表
     * @return
     */
    @RequestMapping("/tolist")
    public String toList() {
        return "/integral/reasonList";
    }

    /**
     * 查询
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<TbIntegralItem> list() {
        List<TbIntegralItem> list = integralItemService.list();
        return list;
    }

    /**
     * 添加
     * @param integralItem
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public ServiceResult add(TbIntegralItem integralItem) {
        integralItem.setCreateTime(SC.getNowDate());
        ServiceResult result = integralItemService.addItem(integralItem);
        return result;
    }

    /**
     * 修改
     * @param integralItem
     * @return
     */
    @RequestMapping("/modify")
    @ResponseBody
    public ServiceResult modify(TbIntegralItem integralItem) {
        ServiceResult result = integralItemService.modifyItem(integralItem);
        return result;
    }

    /**
     *查询分数
     * @param id
     * @return
     */
    @RequestMapping("/get")
    @ResponseBody
    public TbIntegralItem get(Integer id){
        TbIntegralItem tbIntegralItem = integralItemService.get(id);
        return tbIntegralItem;
    }
}
