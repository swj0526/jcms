package com.jczx.controller;

import com.jczx.service.AttachmentService;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("delete")
    public ServiceResult delete(Integer linkId){
      /*  attachmentService.de*/
        return null;
    }
}