package com.mall.emaolv.service.base.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties("swagger")
public class SwaggerProperties {
    /**
     * 页面标题
     */
    private String title;
    /**
     * 是否开启swagger，生产环境一般关闭，所以这里定义一个变量
     */
    private Boolean enable;

    /**
     * 项目应用名
     */
    private String applicationName;

    /**
     * 项目版本信息
     */
    private String applicationVersion;

    /**
     * 项目描述信息
     */
    private String applicationDescription;

    /**
     * url地址
     */
    private String url;
    /**
     * basePackage
     */
    private String basePackage;
    /**
     * author
     */
    private String author;
    /**
     * email
     */
    private String email;

}
