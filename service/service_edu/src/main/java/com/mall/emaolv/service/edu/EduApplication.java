package com.mall.emaolv.service.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ：Xiao Hei
 * @description：EduApplication
 * @date ：Created in 2021/10/23 19:33
 */
@EnableSwagger2
@SpringBootApplication
@ComponentScan("com.mall.emaolv.service")
public class EduApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);
    }
}
