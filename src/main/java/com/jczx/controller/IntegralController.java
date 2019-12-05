package com.jczx.controller;

import com.jczx.domain.TbIntegral;
import com.jczx.service.IntegralService;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

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
    public String toList() {
        return "integral/list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public ServiceResult list(String keyword, Integer start, Integer end, Integer page, Integer limit) {
        Pager pager = new Pager();
        pager.setPageSize(limit);
        pager.setCurrentPage(page);
        List<TbIntegral> list = integralService.list(keyword, start, end, pager);
        return layuiList(list,pager);
    }


    @RequestMapping("/toparticular")
    public String particular(Integer id, String name, Map<String, Object> map) {
        map.put("id",id);
        map.put("name",name);
        return "integral/particular";
    }

}
