package com.jczx.controller;

import com.jczx.domain.TbHomework;
import com.jczx.service.HomeworkService;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author 丛枭钰
 * @description 作业上传页面
 * @create 2019-11-14 14:29
 */
@RequestMapping("/work")
@Controller
public class HomeworkController extends BaseController{
    @Autowired
    private HomeworkService homeworkService;

    /**
     * 上传页面
     *
     * @return
     */

    @RequestMapping("/upload")
    public String workUploadPage() {
        return "work/upload";
    }

    /**
     * 查询页面
     *
     * @return
     */
    @RequestMapping("/tolist")
    public String list() {
        return "work/list";
    }

    @RequestMapping("/uploading")
    public String uploading() {
        return "work/studentwork";
    }

    @RequestMapping("/download")
    public String download() {
        return "work/workDownload";
    }

    @RequestMapping("/toadd")
    public String add() {
        return "work/addWork";
    }

    @RequestMapping("/add/homework")
    @ResponseBody
    public ServiceResult addHomework(TbHomework homework) {
        System.out.println(homework.getEndTime());
        ServiceResult result = homeworkService.addHomework(homework);
        return result;
    }
    /**
     * 查询
     *
     * @param
     * @return
     */
    @RequestMapping("/list/homework")
    @ResponseBody
    public ServiceResult listHomework(String keywords ,Integer majorId,String scopeTime, Integer page, Integer limit) {
        Pager pager = checkPager(limit, page);
        List<TbHomework> list = homeworkService.list(keywords, majorId, scopeTime,pager);
        return layuiList(list, pager);


    }
    /**
     * 用于修改
     *
     * @param
     * @return
     */
    @RequestMapping("/get/homework")

    public String getHomework(Integer id, Map<String,Object> map) {
        System.out.println(id);
        TbHomework homework = homeworkService.getHomework(id);
        map.put("homework",homework);
        System.out.println(homework.getEndTime());
        map.put("endTime",homework.getEndTime().toString());
        return "work/modifyWork";
    }
}
