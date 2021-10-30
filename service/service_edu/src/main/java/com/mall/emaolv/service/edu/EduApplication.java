package com.mall.emaolv.service.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;


/**
 * @author ：Xiao Hei
 * @description：EduApplication
 * @date ：Created in 2021/10/23 19:33
 */
@EnableDiscoveryClient
@EnableOpenApi
@SpringBootApplication
@ComponentScan("com.mall.emaolv.service")
public class EduApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);
    }
}
