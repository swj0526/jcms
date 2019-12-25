package com.jczx.controller;

import com.jczx.service.PayBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author swj
 * @description home首页数据统计
 * @create 2019-11-14 13:55
 */
@RequestMapping("/home")
@Controller
public class HomeController extends BaseController {
@Autowired
private PayBillService payBillService;
    @RequestMapping("/main")
    private String mianHome() {
      getPath();
        return "/home/main";
    }

    @RequestMapping("/context")
    private String context() {
        return "/home/context";
    }
}