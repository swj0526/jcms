package com.jczx.controller;

import com.jczx.domain.TbAttachment;
import com.jczx.domain.TbHomework;
import com.jczx.domain.TbStudentWork;
import com.jczx.service.AttachmentService;
import com.jczx.service.HomeworkService;
import com.jczx.service.StudentWorkService;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.render.Render;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
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
    private AttachmentService attachmentService;
    @Autowired
    private StudentWorkService studentWorkService;

    /**
     * 上传页面
     *
     * @return
     */
    @RequestMapping("/toupload")
    public String toUpload() {
        return "/work/upload";
    }

    /**
     * 作业列表
     *
     * @return
     */
    @RequestMapping("/tolist")
    public String list() {
        return "/work/list";
    }

    /**
     * 上传
     *
     * @param file
     * @return
     */
    @RequestMapping("/static/upload")
    @ResponseBody
    public Map<String, Object> upload(MultipartFile file) {
        ServiceResult result = homeworkService.uploadFile(file, getTeacherPath());
        Map map = uploadeResult(result);
        return map;
    }
    @RequestMapping("/modifyscore")
    @ResponseBody
    public ServiceResult modifyScore(Integer id,Integer studentId,Integer score){
        ServiceResult serviceResult = studentWorkService.modifyScore(id, studentId, score);
        return serviceResult;
    }
    @RequestMapping("/modifyestimateContent")
    @ResponseBody
    public ServiceResult modifyScore(Integer id,Integer studentId,String estimateContent){
        ServiceResult serviceResult = studentWorkService.modifyEstimateContent(id, studentId, estimateContent);
        return serviceResult;
    }


    @RequestMapping("/download")
    public String download(Integer id, Map<String, Object> map) {
        List<TbStudentWork> studentWork = studentWorkService.listWork(id);
        map.put("studentWork", studentWork);
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
    public ServiceResult addHomework(TbHomework homework, Integer attachmentId) {
        if (attachmentId != 0) {
            homework.setHasAttachment(true);
        }
        ServiceResult result = homeworkService.addHomework(homework);
        Integer homeworkId = homework.getId();
        ServiceResult attachmentResult = attachmentService.modifyAttachment(attachmentId, homeworkId);
        return attachmentResult;
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
    @RequestMapping("/get/modify/homework")
    public String getHomework(Integer id, Map<String, Object> map) {
        TbHomework homework = homeworkService.getById(id);
        map.put("homework", homework);
        TbAttachment attachment = attachmentService.getAttachment(homework.getId(), TbAttachment.TYPE_TEACHERFILE);
        map.put("attachment", attachment);
        return "/work/modifyWork";
    }

    /**
     * 用于查看详情
     *
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("/get/details/homework")
    public String getDetailsHomework(Integer id, Map<String, Object> map) {
        TbHomework homework = homeworkService.getById(id);
        map.put("homework", homework);
        TbAttachment attachment = attachmentService.getAttachment(homework.getId(), TbAttachment.TYPE_TEACHERFILE);
        map.put("attachment", attachment);
        return "/work/detailsWork";
    }

    @RequestMapping("/modify/homework")
    @ResponseBody
    public ServiceResult modifyHomework(TbHomework homework, Integer attachmentId) {
        TbAttachment attachment = attachmentService.getById(attachmentId);
        attachment.setLinkId(homework.getId());
        attachmentService.modify(attachment);
        return homeworkService.modifyHomework(homework);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ServiceResult delete(Integer id) {
        TbHomework homework = homeworkService.getById(id);
        homeworkService.del(homework);
        ServiceResult result = attachmentService.deleteAttachment(id, TbAttachment.TYPE_TEACHERFILE);
        return result;
    }

    @RequestMapping("/dofile")
    public Render dofile(Integer id) throws IOException {
        TbAttachment attachment = attachmentService.getById(id);
        File file = new File("E:/work/jcms/src/main/resources/static/upload/teacherFile/1577176050025R6R.png");
        System.out.println(getPath());
        System.out.println(attachment.getURL());
        return Render.renderFile(attachment.getName(), new FileInputStream(file));
    }
}
