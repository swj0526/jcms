package com.jczx.core.Interceptor;

import com.jczx.controller.HomeworkController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author swj
 * @create 2019-11-06 20:30
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Autowired
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginHandlerInterceptor.class);
    /**
     * 执行controller之前
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("basePath", request.getRequestURL());
        //1.判断是否存在注解
        if (!(handler instanceof HandlerMethod)) {
            LOGGER.info("不是HandlerMethod类型，则无需检查");
            return true;
        }
        HandlerMethod method = (HandlerMethod) handler;
        boolean hasLoginAnnotation = method.getMethod().isAnnotationPresent(RequestMapping.class);
        if (!hasLoginAnnotation) {
            //不存在LoginRequired注解，则直接通过
            LOGGER.info("不存在LoginRequired注解，则直接通过");
            return true;
        }
        RequestMapping loginRequired = method.getMethod().getAnnotation(RequestMapping.class);
        //2.required=false,则无需检查是否登录
        if (true) {//!loginRequired.required()
            LOGGER.info("required=false,则无需检查是否登录");
            return true;
        }
        //3.登录状态检查,使用response返回指定信息
        LOGGER.info("required=true,需检查是否登录");
        response.getWriter().append("you need login!");
        return false;
    }


    /**
     * 执行controller之后,渲染之前
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 渲染之后,返回给html之前
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
