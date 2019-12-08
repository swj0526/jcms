package com.jczx.controller;

import com.jczx.domain.TbStudent;
import com.jczx.service.RecruitService;
import com.jczx.service.StudentService;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.render.Render;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 于振华
 */
@Controller
@RequestMapping("/recruit")
public class RecruitController extends BaseController {
    @Autowired
    private RecruitService recruitService;
    @Autowired
    private StudentService studentService;

    /**
     * 到招生页面
     * 于振华
     *
     * @return
     */
    @RequestMapping("/torecruit")
    public String recruit() {
        return "/recruit/recruit";
    }

    /**
     * 数据统计页面
     *
     * @return
     */
    @RequestMapping("/todata")
    private String recruitData() {
        return "/recruit/recruitdata";
    }

    /**
     * 添加招生学生页面
     */
    @RequestMapping("/toadd")
    public String toAdd() {
        return "/recruit/addrecurit";
    }

    /**
     * 修改学生页面信息
     */
    @RequestMapping("/tomodify")
    public String toModify(Integer id, Map<String, Object> map) {
        TbStudent student = studentService.getById(id);
        map.put("student", student);
        return "/recruit/modifyrecurit";
    }

    /**
     * 添加招生信息
     */
    @RequestMapping("/add")
    @ResponseBody
    public ServiceResult addRecruit(TbStudent student) {
        ServiceResult result = recruitService.addRecruit(student);
        return result;
    }

    /**
     * 修改招生信息
     */
    @RequestMapping("/modify")
    @ResponseBody
    public ServiceResult modifyRecruit(TbStudent student) {
        ServiceResult result = recruitService.modifyRecruit(student);
        return result;
    }

    /**
     * 删除
     *
     * @param student
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ServiceResult deleteRecruit(TbStudent student) {
        ServiceResult result = recruitService.deleteRecruit(student);
        return result;
    }

    /**
     * 查询
     *
     * @param
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public ServiceResult listRecruit(String keywords, String labelIds,String createTime,Integer channelId, String sex, Integer page, Integer limit) {
        Pager pager = checkPager(limit, page);
        List<TbStudent> list = recruitService.listRecruit(keywords, labelIds, createTime,channelId,sex, pager);
        return layuiList(list, pager);
    }

    /**
     * 导出
     * @param
     * @param labelIds
     * @param sex
     * @param
     * @return
     */
    @RequestMapping("/exportExcel")
    @ResponseBody
    public Render excel(String keywords, String labelIds,String createTime, Integer channelId,String sex) {
        InputStream inputStream = recruitService.studentExcel(keywords, labelIds,createTime, sex,channelId);
        return Render.renderFile("招生信息表.xls", inputStream);
    }

    /**
     * 文件上床
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RecruitController.class);

    @PostMapping("/upload")
    @ResponseBody
    public Map<String ,Object>upload(@RequestParam("file") MultipartFile file)  {
        System.out.println("开始");
        Map<String,Object> map = new HashMap<>();
         map.put("code",0);
        if (file.isEmpty()) {
            map.put("error","上传失败，请选择文件");
            return map ;
        }
        String fileName = file.getOriginalFilename();//获取文件名称
        String filePath = "D:/IDEA_Project/";
        System.out.println(fileName+"mmmmmmmmmmmmmmmmm");
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            LOGGER.info("上传成功");
            return map;
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return map;
    }

}
