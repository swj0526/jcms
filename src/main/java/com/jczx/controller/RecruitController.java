package com.jczx.controller;

import com.jczx.bean.ResultBean;
import com.jczx.domain.TbStudent;
import com.jczx.service.RecruitService;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * yuzhenhua
 */
@Controller
@RequestMapping("/recruit")
public class RecruitController extends BaseController {
    @Autowired
    private RecruitService recruitService;
    /**
     * 到招生页面
     *
     * @return
     */
    @RequestMapping("/torecruit")
    public String recruit() {
        return "recruit/recruit";
    }

    /**
     * 到渠道页面
     *
     * @return
     */
    @RequestMapping("/tofollow")
    public String follow() {
        return "recruit/follow";
    }

    /**
     * 详情
     *
     * @return
     */
    @RequestMapping("/modifyfollow")
    public String upFollow() {
        return "recruit/modifyfollow";
    }

    /**
     * 数据统计页面
     *
     * @return
     */
    @RequestMapping("/data")
    private String recruitData() {
        return "recruit/recruitdata";
    }
    /**
     * 添加招生信息
     */
    @RequestMapping("/add")
    @ResponseBody
    public ServiceResult addRecruit(TbStudent student) {
        ServiceResult add = recruitService.addRecruit(student);
        return add;
    }
    /**
     * 修改招生信息
     */
    @RequestMapping("/modify")
    @ResponseBody
    public ServiceResult modifyRecruit(TbStudent student){
        ServiceResult modify = recruitService.modifyRecruit(student);
        return modify;
    }

    /**
     * 删除
     * @param student
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ServiceResult deleteRecruit(TbStudent student){
        return null;
    }


}
