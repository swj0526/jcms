package com.jczx.controller;

import com.jczx.domain.TbMajor;
import com.jczx.service.MajorService;
import net.atomarrow.bean.ServiceResult;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 孙文举
 * 专业表的管理
 *
 * @create 2019-11-20 22:22
 */
@RequestMapping("major")
@Controller
public class MajorController {
    @Autowired
    private MajorService majorService;

    /**
     * 到专业-班级管理页面
     *
     * @return
     */
    @RequestMapping("tolist")
    public String tolist(Map<String, List<TbMajor>> map,String keywords) {
        List<TbMajor> list = majorService.listMajor(keywords);
        map.put("list", list);
        return "/major/list";
    }

    @RequestMapping("information")
    public String information() {
        return "/major/information";
    }

    /**
     * 新增专业
     *
     * @param major
     * @return
     */
    @RequestMapping("add/major")
    @ResponseBody
    public ServiceResult major(TbMajor major) {
        return majorService.addMajor(major);
    }

    /**
     * 新增班级
     *
     * @param major
     * @return
     */
    @RequestMapping("add/class")
    @ResponseBody
    public ServiceResult classGrade(TbMajor major) {
        return majorService.addClass(major);
    }

    /**
     * 修改专业-班级
     *
     * @param major
     * @return
     */
    @RequestMapping("/modify")
    @ResponseBody
    public ServiceResult modify(TbMajor major) {
        return majorService.modifyMajor(major);
    }

    /**
     * 根据id查找某个班级专业
     * @param id
     * @return
     */
    @RequestMapping("/get")
    @ResponseBody
    public TbMajor get(Integer id) {
        return majorService.getMajor(id);
    }

    /**
     * 根据id删除专业班级
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public  ServiceResult delete(Integer id){
       return  majorService.deleteMajor(id);
    }

    /**
     * 给下拉选用的
     * @return
     */
    @RequestMapping("/list/select")
    @ResponseBody
    public List<TbMajor> listSelect(){
        List<TbMajor> list = majorService.listMajor(null);
        return list;
    }
}
