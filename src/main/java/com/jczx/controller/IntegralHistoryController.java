package com.jczx.controller;

import com.jczx.domain.TbIntegralHistory;
import com.jczx.service.IntegralHistoryService;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 丛枭钰
 * @create 2019-11-29 11:40
 */
@RequestMapping("/History")
@Controller
public class IntegralHistoryController extends BaseController {

    @Autowired
    private IntegralHistoryService integralHistoryService;

    @RequestMapping("list")
    @ResponseBody
    public ServiceResult list(Integer id, String name) {
        List<TbIntegralHistory> list = integralHistoryService.list(id, name);
        Pager pager = new Pager();
        return layuiList(list, pager);
    }
    @RequestMapping("historylist")
    @ResponseBody
    public ServiceResult HistoryList(String keyword,String recordTime,Integer major,Integer page,Integer limit) {
        Pager pager = new Pager();
        pager.setPageSize(limit);
        pager.setCurrentPage(page);
        List<TbIntegralHistory> list = integralHistoryService.HistoryList(keyword,recordTime,major,pager);
        return layuiList(list, pager);
    }

    @RequestMapping("/toaddPage")
    public String toAddPage() {
        return "/integral/addPage";
    }
    @RequestMapping("/tosubtractpage")
    public String toSubtractPage() {
        return "/integral/subtractpage";
    }

    @RequestMapping("/add")
    @ResponseBody
    public ServiceResult add(TbIntegralHistory integralHistory){


        ServiceResult add = integralHistoryService.add1(integralHistory);
        return add;

    }
}