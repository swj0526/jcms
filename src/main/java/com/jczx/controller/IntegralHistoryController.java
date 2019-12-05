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

    /**
     * 个人历史记录查询
     * @param id
     * @param name
     * @return
     */
    @RequestMapping("/historylist")
    @ResponseBody
    public ServiceResult list(Integer id, String name) {
        List<TbIntegralHistory> list = integralHistoryService.listIntegralHistory(id);
        Pager pager = new Pager();
        return layuiList(list, pager);
    }

    /**
     *列表查询
     * @param keyword
     * @param recordTime
     * @param major
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public ServiceResult HistoryList(String keyword,String recordTime,Integer major,Integer page,Integer limit) {
        Pager pager = new Pager();
        pager.setPageSize(limit);
        pager.setCurrentPage(page);
        List<TbIntegralHistory> list = integralHistoryService.list(keyword,recordTime,major,pager);
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

    /**
     * 添加
     * @param integralHistory
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public ServiceResult add(TbIntegralHistory integralHistory){
        ServiceResult add = integralHistoryService.addIntegralHistory(integralHistory);
        return add;

    }
}
