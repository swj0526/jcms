package com.jczx.controller;

import com.jczx.annotation.Uncheck;
import com.jczx.domain.TbUser;
import com.jczx.service.UserService;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * 登录
 *
 * @author swj
 * @create 2019-11-13 16:09
 */
@Controller
public class LoginController extends BaseController {
    @Autowired
    private UserService userService;

    /**
     * 登录页面
     *
     * @return
     */
    @Uncheck
    @RequestMapping("/login")
    public String login() {
        return "login/to";
    }

    /**
     * 登录检查
     *
     * @param phone
     * @param password
     * @return
     */
    @Uncheck
    @RequestMapping("/checklogin")
    @ResponseBody
    public ServiceResult checklogin(String phone, String password,HttpSession session) {
        ServiceResult result = userService.get(phone, password);
        if (result.isSuccess() == true) {
            session.setAttribute("user", result.getResult());
        }
        return result;
    }

    /**
     * 注销
     *
     * @return
     */
    @Uncheck
    @RequestMapping("/loginout")
    public String loginOut(HttpSession session) {
        session.removeAttribute("user");
        return "login/to";
    }

}