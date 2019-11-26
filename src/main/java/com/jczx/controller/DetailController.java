package com.jczx.controller;

import com.jczx.domain.TbRecruitDetail;
import com.jczx.domain.TbStudent;
import com.jczx.service.DetailService;
import net.atomarrow.bean.ServiceResult;
import org.omg.CORBA.ServiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 详情
 * @author 于振华
 * @create 2019-11-25 23:42
 */
@Controller
@RequestMapping("/details")
public class DetailController {
    @Autowired
    private DetailService detailService;
    /**
     * 添加跟踪详情信息
     * @param recruitDetail
     * @return
     */
    @RequestMapping("/adddetail")
    public ServiceResult addDetail(TbRecruitDetail recruitDetail){
        ServiceResult result = detailService.add(recruitDetail);
        return result;

    }
}
