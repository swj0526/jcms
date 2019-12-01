package com.jczx.controller;

import com.jczx.domain.TbHomework;
import com.jczx.service.HomeworkService;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 丛枭钰
 * @description 作业上传页面
 * @create 2019-11-14 14:29
 */
@RequestMapping("/work")
@Controller
public class HomeworkController {
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
    @RequestMapping("/list")
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

    @RequestMapping("/add")
    public String add() {
        return "work/addwork";
    }

    @RequestMapping("/add/homework")
    @ResponseBody
    public ServiceResult addHomework(TbHomework homework) {
        System.out.println(homework.getEndTime());
        ServiceResult result = homeworkService.addHomework(homework);
        return result;
    }
}
