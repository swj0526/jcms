package com.jczx.controller;

import com.jczx.domain.TbStudent;
import com.jczx.service.RecruitService;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.render.Render;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;
import java.util.ArrayList;
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

    /**
     * 到招生页面
     * 于振华
     *
     * @return
     */
    @RequestMapping("/torecruit")
    public String recruit() {
        return "recruit/recruit";
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
     * 添加招生学生页面
     */
    @RequestMapping("/toadd")
    public String toAdd() {
        return "recruit/addrecurit";
    }

    /**
     * 修改学生页面信息
     */
    @RequestMapping("/tomodify")
    public String toModify(Integer id, Map<String, Object> map) {
        TbStudent student = recruitService.getStudent(id);
        map.put("student", student);
        map.put("birth", student.getBirthDate().toString());
        map.put("createTime", student.getCreateTime().toString());
        return "/recruit/modifyrecurit";
    }

    /**
     * 添加招生信息
     */
    @RequestMapping("/add")
    @ResponseBody
    public ServiceResult addRecruit(TbStudent student) {
        ServiceResult addRecruit = recruitService.addRecruit(student);
        return addRecruit;
    }

    /**
     * 修改招生信息
     */
    @RequestMapping("/modify")
    @ResponseBody
    public ServiceResult modifyRecruit(TbStudent student) {
        ServiceResult modifyRecruit = recruitService.modifyRecruit(student);
        return modifyRecruit;
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
        ServiceResult deleteRecruit = recruitService.deleteRecruit(student);
        return deleteRecruit;
    }

    /**
     * 查询
     *
     * @param
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public ServiceResult listRecruit(String keywords, String labelIds, String sex, int page, int limit) {
        System.out.println(keywords);
        Pager pager = checkPager(limit, page);
        List<TbStudent> list = recruitService.listRecruit(keywords, labelIds, sex, pager);
         for(TbStudent student:list){
             System.out.println("渠道id:"+student.getChannelId());
             //System.out.println("渠道名称:"+student.getChannelName());
         }
        return layuiList(list, pager);


    }

    /**
     * 招生信息详情
     *
     * @return
     */
    @RequestMapping("/detailfollow")
    public String upFollow(Integer id, Map<String, Object> map) {
        System.out.println(id);
        TbStudent student = recruitService.getStudent(id);

        map.put("birth", student.getBirthDate().toString());
        map.put("createTime", student.getCreateTime().toString());
        map.put("id",student.getId());
        List<TbStudent> list =new ArrayList<>();
        list.add(student);
        map.put("student",list);

        return "recruit/detailfollow";
    }

    /**
     * 导出
     * @param
     * @param labelIds
     * @param sex
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/toExcel")
    @ResponseBody
    public Render ex(String keywords, String labelIds, String sex, int page, int limit) {
        Pager pager = checkPager(limit, page);
        InputStream inputStream = recruitService.studentExcel(keywords, labelIds, sex, pager);
        return Render.renderFile("招生信息表.xls", inputStream);
    }
}
