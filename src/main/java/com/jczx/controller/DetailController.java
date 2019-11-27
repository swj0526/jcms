package com.jczx.controller;

import com.jczx.domain.TbRecruitDetail;
import com.jczx.domain.TbStudent;
import com.jczx.service.DetailService;
import com.jczx.service.RecruitService;
import net.atomarrow.bean.ServiceResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 详情
 *
 * @author 于振华
 * @create 2019-11-25 23:42
 */
@Controller
@RequestMapping("/details")
public class DetailController {
    @Autowired
    private DetailService detailService;
    @Autowired
    private RecruitService recruitService;

    /**
     * 添加跟踪详情信息
     *
     * @param recruitDetail
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public List<TbRecruitDetail> addDetail(TbRecruitDetail recruitDetail,Integer studentId) {
        System.out.println(recruitDetail.getLabelIds());
        ServiceResult result = detailService.addDetail(recruitDetail);
        List<TbRecruitDetail> tbRecruitDetails = detailService.listDetail(studentId);
        return tbRecruitDetails;

    }

    @RequestMapping("/list")
    @ResponseBody
    public List<TbRecruitDetail>list(Integer studentId) {
        List<TbRecruitDetail> tbRecruitDetails = detailService.listDetail(studentId);
        return tbRecruitDetails;
    }

    /**
     * 招生信息详情
     *
     * @return
     */
    @RequestMapping("/todetail")
    public String upFollow(Integer id, Map<String, Object> map) {
        map.put("id",id);
        System.out.println(id);
        TbStudent student = recruitService.getStudent(id);
        map.put("student",student);

        List<TbRecruitDetail> detail = detailService.listDetail(id);
        map.put("detail",detail);
        return "recruit/detailfollow";
    }
}
