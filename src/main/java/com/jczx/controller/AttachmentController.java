package com.jczx.controller;

import com.jczx.domain.TbAttachment;
import com.jczx.service.AttachmentService;
import com.jczx.service.PayBillService;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 孙文举
 * @description 操作附件
 * @create 2019-12-13 10:28
 */
@RequestMapping("/attachment")
@Controller
public class AttachmentController extends BaseController {
    @Autowired
    private AttachmentService attachmentService;
    @Autowired
    private PayBillService payBillService;

    @RequestMapping("/delete")
    public ServiceResult delete(Integer linkId) {
        return attachmentService.deleteAttachment(linkId, TbAttachment.TYPE_TEACHERFILE);

    }
    @RequestMapping("/listimg")
    @ResponseBody
    public List<TbAttachment> listImg(Integer linkId, Integer studentID) {
        List<TbAttachment> list = attachmentService.listImg(linkId, studentID);
        String path = getPath().substring(1, getPath().length() - 1);
        for (int a=0;a<list.size();++a){
            list.get(a).setURL(path+list.get(a).getURL());
        }
        return list;
    }
}