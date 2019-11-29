package com.jczx.controller;

import com.jczx.domain.TbIntegral;
import com.jczx.service.IntegralService;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/integral")
@Controller
public class IntegralController extends BaseController{
    @Autowired
    private IntegralService integralService;
    /**
     * cjw
     *
     * @return
     */
    @RequestMapping("/add")
    public String integral() {
        return "integral/integralPage";
    }

    @RequestMapping("/tolist")
    public String tolist() {
        return "integral/list";
    }

    @RequestMapping("/list")
    public ServiceResult list(String keyword, Integer ScoreA, Integer ScoreB, Integer page, Integer limit) {
        Pager pager = new Pager();
        pager.setPageSize(limit);
        pager.setCurrentPage(page);
        List<TbIntegral> list = integralService.list(keyword, ScoreA, ScoreB, pager);
        return layuiList(list,pager);
    }


    @RequestMapping("/toparticular")
    public String particular() {
        return "integral/particular";
    }

}
