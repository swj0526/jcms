package com.jczx.controller;

import com.jczx.service.DictionaryService;
import com.jczx.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 于振华
 * @create 2019-11-22 15:58
 */
@Controller
@RequestMapping("/follow")
public class FollowController {
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private StudentService studentService;

    /**
     * 渠道管理
     * @return
     */
    @RequestMapping("/to")
    public String toFollow(){
        return "/recruit/follow";
    }
    /**
     * 到渠道统计页面
     ******************
     * @return
     */
 /*   @RequestMapping("/tofollow")
    public String follow(Map<String,Object>map) {
        List<FollowBean> list = studentService.listFollowBean();
        map.put("list",list);
        return "recruit/recruitdata";
    }*/

}
