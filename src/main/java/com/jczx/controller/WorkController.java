package com.jczx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/work")
@Controller
public class WorkController {
    @RequestMapping("/uploading")
    public String workUploadPage(){
     return "work/uploading";
    }
    @RequestMapping("/list")
    public String workQuery(){
        return "work/Query";
    }
}
