package com.jczx.core.Interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author swj
 * @create 2019-11-06 21:01
 */
@Configuration
public class ConfigInterceptor implements WebMvcConfigurer {
    @Bean
    public LoginHandlerInterceptor getSessionInterceptor() {
        return new LoginHandlerInterceptor();
    }

    /**
     * 注册拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getSessionInterceptor());
        InterceptorRegistration inter = registry.addInterceptor(new LoginHandlerInterceptor());
        inter.addPathPatterns("/**"); //拦截的路径
        //  inter.excludePathPatterns("/login", "/**/*.css", "/**/*.js", "../common/common.ftl"); //除了什么不拦截
    }

    /**
     * 重写资源配置
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/test/**")//请求当前路径 会转发到下面的static 下面,
                // 一个*代表匹配一个文件,**代表匹配所有文件及其子文件
                // 一般情况,请求路径和转发的路径,名称相同,
                // .addResourceLocations当满足上面的匹配规则之后,要跳转向文件的真实路径;
                .addResourceLocations("classpath:/static/");
    }

}
