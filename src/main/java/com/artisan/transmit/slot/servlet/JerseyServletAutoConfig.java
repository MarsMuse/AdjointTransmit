package com.artisan.transmit.slot.servlet;

import com.artisan.transmit.slot.jersey.JerseyHeaderFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.Servlet;

/**
 *
 * @author xz man
 * @date 2018/8/7 下午4:28
 * @since v1.0
 *
 *
 */
@Configuration
@ConditionalOnClass(value = {ResourceConfig.class, Servlet.class})
@ConditionalOnBean(value = ResourceConfig.class)
@ConditionalOnProperty(value = "transmit.slot.servlet.enabled", matchIfMissing = true)
public class JerseyServletAutoConfig {

    /**
     * 获取到servlet配置文件
     */
    @Resource
    private ServletHeaderConfig headerConfig;

    /**
     * 获取到注册对象
     */
    @Resource
    private ResourceConfig resourceConfig;

    /**
     *
     * @author xz man
     * @date 2018/8/7 上午10:11
     * @since v1.0
     * 方法描述: 创建Jersey过滤对象，获取到请求头数据
     *
     */
    @Bean
    public JerseyHeaderFilter jerseyHeaderFilter(){

        JerseyHeaderFilter jerseyHeaderFilter = new JerseyHeaderFilter(headerConfig.getPrefixHeader() ,headerConfig.getHeaders());
        if(null != resourceConfig){
            resourceConfig.register(jerseyHeaderFilter);
        }
        return jerseyHeaderFilter;
    }
}
