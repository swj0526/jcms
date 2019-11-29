package com.jczx.controller;

import com.jczx.domain.TbIntegralItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 丛枭钰
 * @create 2019-11-29 13:38
 */
@Controller
public class IntegralItemController extends BaseController{
    @RequestMapping("list")
    @ResponseBody
    public List<TbIntegralItem> list(){

        return null;
    }
}
