package com.jczx.controller;

import com.jczx.domain.TbPayBill;
import com.jczx.system.SC;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.render.Render;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jczx.service.PayBIllService;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private PayBIllService moneyService;

    /**
     * 缴费列表
     *
     * @return
     */
    @RequestMapping("/tolist")
    public String list() {
        return "money/list";
    }

    @RequestMapping("/totype")
    public String toType() {
        return "money/typelist";
    }

    @RequestMapping("/tosemester")
    public String toSemester() {
        return "money/semesterlist";
    }

    @RequestMapping("/topaymentMethod")
    public String toPaymentMethodList() {
        return "money/paymentMethodlist";
    }

    @RequestMapping("/tomodify")
    public String toModify(int id, Map<String, Object> map) {
        TbPayBill bill = moneyService.getBill(id);
        map.put("bill", bill);
        return "money/modify";
    }

    /**
     * 添加页面
     *
     * @return
     */
    @RequestMapping("/toaddBillPage")
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
        ServiceResult add = moneyService.addBill(payBill);
        return add;
    }

    /**
     * 列表查询
     * @param time
     * @param keyword
     * @param typeId
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public ServiceResult list(String time,String keyword, Integer typeId, Integer page, Integer limit) {
        Pager pager = checkPager(limit, page);
        List<TbPayBill> PayBillBean = moneyService.listBill(time,keyword, typeId, pager);
        return layuiList(PayBillBean,pager);
    }

    /**
     * 修改
     * @param payBill
     * @return
     */
    @RequestMapping("/modify")
    @ResponseBody
    public ServiceResult modify(TbPayBill payBill) {
        ServiceResult serviceResult = moneyService.modifyBill(payBill);
        return serviceResult;
    }

    /**
     * 导出
     * @param time
     * @param keyword
     * @param type
     * @return
     */
    @RequestMapping("/toExcel")
    @ResponseBody
    public Render ex(String time,String keyword, Integer type) {
        InputStream inputStream = moneyService.exportExcel(time,keyword, type, null);
        return Render.renderFile("学生信息表.xls", inputStream);
    }


}
