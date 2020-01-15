package com.jczx.controller;

import com.jczx.domain.TbArticle;
import com.jczx.service.ArticleService;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 发布文章
 * 宋家新
 */
@RequestMapping("/article")
@Controller
public class ArticleController extends BaseController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/dispatch")
    public String funds() {
        return "article/dispatch";
    }

    @RequestMapping("/list")
    public String leave() {
        return "article/list";
    }

    @RequestMapping("/teacherList")
    public String teacherList() {
        return "article/teacherList";
    }

    @RequestMapping("/totype")
    public String toType() {
        return "article/typelist";
    }

    @RequestMapping("/details")
    public String details() {
        return "article/details";
    }

    @RequestMapping("/add")
    @ResponseBody
    public ServiceResult addArticle(TbArticle tbArticle) {

        ServiceResult add =articleService.addArticle(tbArticle);
        return add;
    }

    @RequestMapping("/articleList")
    @ResponseBody
    public ServiceResult articleList(String keyword,Integer typeId, Integer state,String time,Integer page,Integer limit){
        Pager pager = checkPager(limit, page);
        List<TbArticle> list = articleService.articleList(keyword,typeId,state,time,pager);
        return layuiList(list,pager);
    }

    @RequestMapping("/articleModify")
    @ResponseBody
    public ServiceResult modifyTeacher(TbArticle tbArticle){
        ServiceResult modify=articleService.articleModify(tbArticle);
        return modify;
    }

}
