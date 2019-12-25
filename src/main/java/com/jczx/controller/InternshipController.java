package com.jczx.controller;

import com.jczx.domain.TbStudent;
import com.jczx.service.InternshipService;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 于振华
 * @create 2019-11-24 19:25
 */
@Controller
@RequestMapping("/internship")
public class InternshipController extends BaseController {
    @Autowired
    private InternshipService internshipService;

    /**
     * 试学页面
     *
     * @return
     */
    @RequestMapping("/to")
    public String toInternship() {
        return "/recruit/internship";
    }


    /**
     * 查看试学人员
     *
     * @param keywords
     * @param
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public ServiceResult listInternship(String keywords, String searchTime, Integer timeState, Integer page, Integer limit) {
        Pager pager = checkPager(limit, page);
        List<TbStudent> list = internshipService.listInternship(keywords, searchTime, timeState, pager);
        return layuiList(list, pager);

    }

    /**
     * 编辑试学时间
     *
     * @param id
     * @param
     * @return
     */
    @RequestMapping("/modify")
    @ResponseBody
    public ServiceResult modifyInternship(Integer id, String startDate, String endDate) {
        ServiceResult result = internshipService.modifyInternship(id, startDate, endDate);
        return result;
    }

    /**
     * 删除试学信息
     *
     * @param student
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ServiceResult deleteInternship(TbStudent student) {
        ServiceResult result = internshipService.deleteInternship(student);
        return result;

    }
}
