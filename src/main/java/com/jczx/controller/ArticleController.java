package com.jczx.controller;

import com.jczx.domain.TbArticle;
import com.jczx.service.ArticleService;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        Date date = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("YYYY-MM-dd");
        String time = dateformat.format(date);
        Date createTime = null;
        try {
            createTime = dateformat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tbArticle.setCreateTime(createTime);
        ServiceResult add =articleService.addArticle(tbArticle);
        return add;
    }

    @RequestMapping("/list")
    @ResponseBody
    public ServiceResult articleList(String keyword, Integer state,Integer page,Integer limit){
        Pager pager = checkPager(limit, page);
        List<TbArticle> article = articleService.articleList(keyword,state,pager);
        return layuiList(article,pager);
    }

}
