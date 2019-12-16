package com.jczx.controller;

import com.jczx.bean.FollowBean;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
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
     * 到渠道统计页面
     * 并且显示统计数据
     *
     * @return
     */
    @RequestMapping("/tofollow")
    public String follow(Map<String, Object> map,Integer channelId,String time) {
        List<FollowBean> list =studentService.listFollowBean(channelId,time);
        map.put("list", list);
        map.put("channelId",channelId);
        map.put("time",time);
        return "recruit/recruitdata";
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
     * 判断学生是否入学
     */
    @RequestMapping("/hasentrance")
    public ServiceResult hasEntrance(Integer id) {
        ServiceResult result = recruitService.hasEntrance(id);
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
    public ServiceResult listRecruit(String keywords, String labelIds, String createTime, Integer channelId, String sex, Integer page, Integer limit) {
        Pager pager = checkPager(limit, page);
        List<TbStudent> list = recruitService.listRecruit(keywords, labelIds, createTime, channelId, sex, pager);
        return layuiList(list, pager);
    }

    @RequestMapping("/listname")
    @ResponseBody
    public List<TbStudent> listRecruitName(String keywords, String labelIds, String createTime, Integer channelId, String sex, Integer page, Integer limit) {
        List<TbStudent> list = recruitService.listRecruit(keywords, labelIds, createTime, channelId, sex, null);
        return list;
    }

    /**
     * 导出
     *
     * @param
     * @param labelIds
     * @param sex
     * @param
     * @return
     */
    @RequestMapping("/exportExcel")
    @ResponseBody
    public Render excel(String keywords, String labelIds, String createTime, Integer channelId, String sex) {
        InputStream inputStream = recruitService.studentExcel(keywords, labelIds, createTime, sex, channelId);
        return Render.renderFile("招生信息表.xls", inputStream);
    }

    /**
     * 文件上传
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RecruitController.class);//日志

    @PostMapping("/upload")
    @ResponseBody
    public Map<String, Object> upload(@RequestParam("file") MultipartFile file) throws Throwable {
        ServiceResult result = recruitService.upload(file, getExcelPath());
        recruitService.inputStudent(result.getResult().toString());
        Map map = uploadeResult(result);
        return map;
    }
}
