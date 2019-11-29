package com.jczx.controller;

import com.jczx.domain.TbIntegralItem;
import com.jczx.service.IntegralItemService;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 丛枭钰
 * @create 2019-11-29 13:38
 */
@RequestMapping("integral/item")
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
        System.out.println("reason:"+integralItem.getReason());
        System.out.println("remark:"+integralItem.getRemark());
        System.out.println("score:"+integralItem.getScore());
        System.out.println("type:"+integralItem.getType());
        ServiceResult result = integralItemService.add(integralItem);
        return result;
    }
}
