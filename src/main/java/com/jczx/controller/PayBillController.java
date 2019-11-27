package com.jczx.controller;

import com.jczx.bean.ListByPage;
import com.jczx.domain.TbPayBill;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.render.Render;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jczx.service.moneyService;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 丛枭钰
 * @description 缴费页面
 * @create 2019-11-14 14:29
 */
@RequestMapping("/money")
@Controller
public class PayBillController extends BaseController {
    @Autowired
    private moneyService moneyService;

    /**
     * 缴费列表
     *
     * @return
     */
    @RequestMapping("/tolist")
    public String list() {
        return "money/list";
    }

    @RequestMapping("/kkk")
    public String kkk() {
        return "money/kkk";
    }
    @RequestMapping("/tomodify")
    public String toModify(int id,Map<String,Object> map) {
        TbPayBill bill = moneyService.getBill(id);
        bill.setName("张三");
        bill.setSemester("20年");
        bill.setPaymentMethod("学费");
        bill.setType("微信");
        map.put("bill",bill);
        return "money/modify";
    }
    /**
     * 添加页面
     * @return
     */
    @RequestMapping("/addBillPage")
    public String addBill() {

        return "money/add";
    }

    /**
     * 添加
     *
     * @param payBill
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public ServiceResult add(TbPayBill payBill) {
        Date date = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("YYYY-MM-dd");
        String time = dateformat.format(date);
        Date createTime = null;
        try {
            createTime = dateformat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        payBill.setCreateTime(createTime);
        ServiceResult add = moneyService.addBill(payBill);
        return add;
    }

    /**
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public ListByPage getList(String keyword, Integer type, Date date,int page, int limit) {
        Pager pager = new Pager();
        pager.setPageSize(limit);
        pager.setCurrentPage(page);
        List<TbPayBill> PayBillBean = moneyService.listBill(keyword,type,date,pager);
        ListByPage list=new ListByPage();
        list.setData(PayBillBean);
        list.setCount(pager.getDataTotal());
        return list;
    }

    @RequestMapping("/modify")
    @ResponseBody
    public ServiceResult modify(TbPayBill payBill) {
        ServiceResult serviceResult = moneyService.modifyBill(payBill);
        return serviceResult;
    }
    @RequestMapping("/toExcel")
    @ResponseBody
    public Render ex(String keyword, Integer type, Date date)  {
        Pager pager = new Pager();
        pager.setPageSize(100000);
        pager.setCurrentPage(1);
        InputStream inputStream = moneyService.xlsx(keyword,type,date,pager);
        return Render.renderFile("学生信息表.xls", inputStream);
    }


}
