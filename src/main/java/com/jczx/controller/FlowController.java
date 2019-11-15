package com.jczx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/flow")
@Controller
public class FlowController {
    @RequestMapping("/funds")
    public String funds(){
        return "flow/funds";
    }

    @RequestMapping("/fundsApprover")
    public String fundsApprover(){
        return "flow/fundsApprover";
    }

    @RequestMapping("/leave")
    public String leave(){
        return "flow/leave";
    }

    @RequestMapping("/leaveApprover")
    public String leaveApprover(){
        return "flow/leaveApprover";
    }




}
