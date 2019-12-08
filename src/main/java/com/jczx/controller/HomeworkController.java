package com.jczx.controller;

import com.jczx.domain.TbHomework;
import com.jczx.service.HomeworkService;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author 丛枭钰
 * @description 作业上传页面
 * @create 2019-11-14 14:29
 */
@RequestMapping("/work")
@Controller
public class HomeworkController extends BaseController {
    @Autowired
    private HomeworkService homeworkService;
    @Autowired
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeworkController.class);
    /**
     * 上传页面
     *
     * @return
     */


    /**
     * 作业列表
     *
     * @return
     */
    @RequestMapping("/tolist")
    public String list() {
        return "/work/list";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile files) {
        System.out.println(files);
        if (files.isEmpty()) {
            return "上传失败，请选择文件";
        }

        String fileName = files.getOriginalFilename();//获取文件名称
        String filePath = "E:/upload/";
        System.out.println(fileName + "mmmmmmmmmmmmmmmmm");
        File dest = new File(filePath + fileName);
        try {
            files.transferTo(dest);
            LOGGER.info("上传成功");
            return "上传成功";
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return "上传失败！";
    }

    @RequestMapping("/")
    public String index() {
        return "/upload";
    }

    @RequestMapping("/download")
    public String download() {
        return "/work/workDownload";
    }

    /**
     * 添加修改页面公用一个页面
     *
     * @return
     */
    @RequestMapping("/toadd")
    public String add() {
        return "/work/addWork";
    }

    /*
     *添加作业的方法
     */
    @RequestMapping("/add/homework")
    @ResponseBody
    public ServiceResult addHomework(TbHomework homework) {
        ServiceResult result = homeworkService.addHomework(homework);
        return result;
    }

    /**
     * 作业列表
     *
     * @param
     * @return
     */
    @RequestMapping("/list/homework")
    @ResponseBody
    public ServiceResult listHomework(String keywords, Integer majorId, String scopeTime, Integer page, Integer limit) {
        Pager pager = checkPager(limit, page);
        List<TbHomework> list = homeworkService.list(keywords, majorId, scopeTime, pager);
        return layuiList(list, pager);


    }

    /**
     * 查找一个作业,用于修改给页面赋值
     *
     * @param
     * @return
     */
    @RequestMapping("/get/homework")

    public String getHomework(Integer id, Map<String, Object> map) {
        TbHomework homework = homeworkService.getById(id);
        map.put("homework", homework);
        return "/work/modifyWork";
    }

    @RequestMapping("/modify/homework")
    @ResponseBody
    public ServiceResult modifyHomework(TbHomework homework) {
        return homeworkService.modifyHomework(homework);
    }
}
