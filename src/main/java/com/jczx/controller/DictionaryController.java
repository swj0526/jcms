package com.jczx.controller;


import com.jczx.domain.TbDictionary;
import com.jczx.service.DictionaryService;
import com.jczx.system.OptionInterface;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 孙文举
 * @description
 * @create 2019-11-22 9:19
 */
@RequestMapping("/dictionary")
@RestController
public class DictionaryController extends BaseController {
    @Autowired
    private DictionaryService dictionaryService;

    /**
     * 添加招生来源渠道信息
     * @param name
     * @param remark
     * @return
     */
    @RequestMapping("/add/channel")
    public ServiceResult addChannel(String name, String remark) {
        ServiceResult result = dictionaryService.addDictionary(name, remark,TbDictionary.TYPE_CHANNEL );
        return result;
    }

    /**
     * 添加意向标签
     * @param name
     * @param remark
     * @return
     */
    @RequestMapping("/add/label")
    public ServiceResult addLabel(String name, String remark) {
        ServiceResult result = dictionaryService.addDictionary(name, remark,TbDictionary.TYPE_LABEL );
        return result;
    }

    /**
     * 查询标签
     * @return
     */
    @RequestMapping("/list/label")
    public List<? extends OptionInterface> labelOptions() {
        System.out.println("查询标签");
        List<TbDictionary> list = dictionaryService.list(TbDictionary.TYPE_LABEL, null, null);
        return list;
    }

    /**
     * 添加招缴费方式信息
     * @param name
     * @param remark
     * @return
     */
    @RequestMapping("/add/payWay")
    public ServiceResult addPayWay(String name, String remark) {
        ServiceResult result = dictionaryService.addDictionary(name, remark,TbDictionary.TYPE_PAY );
        return result;
    }
    /**
     * 添加学年信息
     * @param name
     * @param remark
     * @return
     */
    @RequestMapping("/add/payTerm")
    public ServiceResult addPayTerm(String name, String remark) {
        ServiceResult result = dictionaryService.addDictionary(name, remark,TbDictionary.TYPE_TERM );
        return result;
    }
    /**
     * 添加招缴费类型信息
     * @param name
     * @param remark
     * @return
     */
    @RequestMapping("/add/payType")
    public ServiceResult addPayType(String name, String remark) {
        ServiceResult result = dictionaryService.addDictionary(name, remark,TbDictionary.TYPE_PAY_BILL );
        return result;
    }
    /**
     * 添加公告类型
     * @param name
     * @param remark
     * @return
     */
    @RequestMapping("/add/dispatch")
    public ServiceResult addDispatch(String name, String remark) {
        ServiceResult result = dictionaryService.addDictionary(name, remark,TbDictionary.TYPE_DISPATCH );
        return result;
    }
    /**
     * 删除渠道
     * @param id
     * @return
     */
    @RequestMapping("/delete/channel")
    public ServiceResult deleteChannel(Integer id) {
        ServiceResult result = dictionaryService.deleteChannel(id);
        return result;
    }
    /**
     * 删除学年
     * @param id
     * @return
     */
    @RequestMapping("/delete/term")
    public ServiceResult deleteTerm(Integer id) {
        ServiceResult result = dictionaryService.deleteTerm(id);
        return result;
    }
    /**
     * 删除缴费方式
     * @param id
     * @return
     */
    @RequestMapping("/delete/method")
    public ServiceResult deleteMethod(Integer id) {
        ServiceResult result = dictionaryService.deleteMthod(id);
        return result;
    }
    /**
     * 删除缴费类型
     * @param id
     * @return
     */
    @RequestMapping("/delete/type")
    public ServiceResult deleteType(Integer id) {
        ServiceResult result = dictionaryService.deleteType(id);
        return result;
    }
    /**
     * 删除公告类型
     * @param id
     * @return
     */
    @RequestMapping("/delete/articleType")
    public ServiceResult deleteArticleType(Integer id) {
        ServiceResult result = dictionaryService.deleteArticleType(id);
        return result;
    }




















    @RequestMapping("/modify")
    public ServiceResult modify(String name, String remark, Integer id) {
        ServiceResult result = dictionaryService.modifyDictionary(name, remark, id);
        return result;
    }

    /**
     * 带分页的来源渠道列表
     * @param keywords
     * @param limit
     * @param page
     * @return
     */
    @RequestMapping("/list/channel")
    public ServiceResult channel(String keywords, Integer limit, Integer page) {
        Pager pager = checkPager(limit, page);
        List<TbDictionary> list = dictionaryService.list(TbDictionary.TYPE_CHANNEL, keywords, pager);
        return layuiList(list, pager);
    }

    /**
     * 不带分页的的来源渠道列表
     * @return
     */
    @RequestMapping("/list/channel/options")
    public List<? extends OptionInterface> channelOptions() {
        List<TbDictionary> list = dictionaryService.list(TbDictionary.TYPE_CHANNEL, null, null);
        return list;
    }
    /**
     * 不带分页的的缴费方式列表
     * @return
     */
    @RequestMapping("/list/payWay/options")
    public List<? extends OptionInterface> payWayOptions() {
        System.out.println(1);
        List<TbDictionary> list = dictionaryService.list(TbDictionary.TYPE_PAY, null, null);
        return list;
    }
    /**
     * 不带分页的的缴费类型列表
     * @return
     */
    @RequestMapping("/list/payType/options")
        public List<? extends OptionInterface> payTypeOptions() {
        List<TbDictionary> list = dictionaryService.list(TbDictionary.TYPE_PAY_BILL, null, null);
        return list;
    }
    /**
     * 不带分页的的学年列表
     * @return
     */
    @RequestMapping("/list/payTerm/options")
    public List<? extends OptionInterface> payTermOptions() {
        List<TbDictionary> list = dictionaryService.list(TbDictionary.TYPE_TERM, null, null);
        return list;
    }
    /**
     * 不带分页的的发文类型列表
     * @return
     */
    @RequestMapping("/list/dispatch/options")
    public List<? extends OptionInterface> dispatchOptions() {
        List<TbDictionary> list = dictionaryService.list(TbDictionary.TYPE_DISPATCH, null, null);
        return list;
    }
}