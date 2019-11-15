package com.jczx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 丛枭钰
 * @description 作业上传页面
 * @create 2019-11-14 14:29
 */
@RequestMapping("/work")
@Controller
public class WorkController {
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
    public String workQuery() {
        return "work/list";
    }
    @RequestMapping("/download")
    public String  download() {
        return "work/studentwork";
    }
}
