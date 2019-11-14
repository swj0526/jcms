package com.jczx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/flow")
@Controller
public class FlowController {
    @RequestMapping("/funds")
    public String funds(){
        return "flow/flowFunds";
    }

    @RequestMapping("/leave")
    public String leave(){
        return "flow/flowLeave";
    }

    @RequestMapping("/approver")
    public String approver(){
        return "flow/approver";
    }

}
