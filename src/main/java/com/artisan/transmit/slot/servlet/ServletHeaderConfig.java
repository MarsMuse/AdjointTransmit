package com.artisan.transmit.slot.servlet;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author xz man
 * @date 2018/8/7 下午6:21
 * @since v1.0
 * Servlet 拦截头信息配置文件
 *
 */
@ConfigurationProperties(prefix = "transmit.slot.servlet",ignoreUnknownFields = true)
public class ServletHeaderConfig {

    /**
     * 需要拦截下来的头信息
     */
    private String[] headers={"userId","loginName","userSource"};

    /**
     * 需要匹配的头信息名称前缀
     */
    private String prefixHeader="artist-";

    /**
     * 是否开启
     */
    private boolean enabled = true;

    public String[] getHeaders() {
        return headers;
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }

    public String getPrefixHeader() {
        return prefixHeader;
    }

    public void setPrefixHeader(String prefixHeader) {
        this.prefixHeader = prefixHeader;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
