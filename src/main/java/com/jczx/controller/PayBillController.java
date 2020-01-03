package com.jczx.controller;

import com.jczx.bean.RemindBean;
import com.jczx.domain.TbPayBill;
import com.jczx.service.PayBillService;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.render.Render;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
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
    private PayBillService payBillService;


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
        TbPayBill bill = payBillService.getBill(id);
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
        ServiceResult add = payBillService.addBill(payBill);

        return add;
    }

    /**
     * 列表查询
     *
     * @param time
     * @param keyword
     * @param typeId
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public ServiceResult list(String time, String keyword, Integer typeId, Integer page, Integer limit) {
        Pager pager = checkPager(limit, page);
        List<TbPayBill> PayBillBean = payBillService.listBill(time, keyword, typeId, pager);
        return layuiList(PayBillBean, pager);
    }

    /**
     * 修改
     *
     * @param payBill
     * @return
     */
    @RequestMapping("/modify")
    @ResponseBody
    public ServiceResult modify(TbPayBill payBill) {
        System.out.println(payBill.getStudentId());
        ServiceResult serviceResult = payBillService.modifyBill(payBill);
        return serviceResult;
    }

    /**
     * 导出
     *
     * @param time
     * @param keyword
     * @param type
     * @return
     */
    @RequestMapping("/toExcel")
    @ResponseBody
    public Render ex(String time, String keyword, Integer type) {
        InputStream inputStream = payBillService.exportExcel(time, keyword, type, null);
        return Render.renderFile("学生信息表.xls", inputStream);
    }

    @RequestMapping("/static/upload")
    @ResponseBody
    public Map<String, Object> upload(Integer linkId, Integer studentId, MultipartFile file) {
        ServiceResult result = payBillService.uploadFile(file, getImgPath(), linkId, studentId);
        Map map = uploadeResult(result);
        return map;
    }
    /**
     * 缴费提醒列表
     *
     * @return
     */
    @RequestMapping("/list/remind")
    @ResponseBody
    public List<RemindBean> ListRemind(String keywords, String startTime, Integer page, Integer limit) {
        Pager pager = checkPager(limit, page);
        return payBillService.ListRemind(keywords,startTime,pager);
    }
}
