package com.jczx.controller;

import com.jczx.domain.TbIntegralItem;
import com.jczx.service.IntegralItemService;
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
@RequestMapping("/integral/item")
@Controller
public class IntegralItemController extends BaseController {
    @Autowired
    private IntegralItemService integralItemService;

    @RequestMapping("/tolist")
    public String toList() {
        return "/integral/reasonList";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<TbIntegralItem> list() {
        List<TbIntegralItem> list = integralItemService.list();
        return list;
    }

    @RequestMapping("/add")
    @ResponseBody
    public ServiceResult add(TbIntegralItem integralItem) {
        Date date = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("YYYY-MM-dd");
        String time = dateformat.format(date);
        Date createTime = null;
        try {
            createTime = dateformat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        integralItem.setCreateTime(createTime);
        ServiceResult result = integralItemService.addItem(integralItem);
        return result;
    }

    @RequestMapping("/modify")
    @ResponseBody
    public ServiceResult modify(TbIntegralItem integralItem) {
        ServiceResult result = integralItemService.modifyItem(integralItem);
        return result;
    }
    @RequestMapping("/get")
    @ResponseBody
    public TbIntegralItem get(Integer id){
        TbIntegralItem tbIntegralItem = integralItemService.get(id);
        return tbIntegralItem;
    }
}
