package com.artisan.transmit.slot.servlet;


import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;
import javax.servlet.Servlet;

/**
 *
 * @author xz man
 * @date 2018/7/19 下午4:42
 * 注解自动配置
 *
 */
@Configuration
@ConditionalOnProperty(value = "transmit.slot.servlet.enabled", matchIfMissing = true)
@ConditionalOnClass({Servlet.class, DispatcherServlet.class})
public class ServletHeaderGrabAutoConfiguration extends WebMvcConfigurerAdapter {

    @Resource
    private ServletHeaderConfig servletHeaderConfig;

    /**
     *
     * @author xz man
     * @date 2018/7/19 下午5:04
     * 添加拦截器
     *
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HeaderGrabInterceptor(servletHeaderConfig.getPrefixHeader(),
                servletHeaderConfig.getHeaders())).addPathPatterns("/**");
    }


}
