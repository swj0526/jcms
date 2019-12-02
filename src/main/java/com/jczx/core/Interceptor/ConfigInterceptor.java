package com.jczx.core.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author swj
 * @create 2019-11-06 21:01
 */
@Configuration
public class ConfigInterceptor implements WebMvcConfigurer {
    /**
     * 注册拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
         InterceptorRegistration inter = registry.addInterceptor(new LoginHandlerInterceptor());
         inter.addPathPatterns("/**"); //拦截的路径
         inter.excludePathPatterns("/", "/logout", "/register", "/loginCheck",
         "/registerCheck", "/**/*.css", "/**/*.js"); //除了什么不拦截
    }
}
