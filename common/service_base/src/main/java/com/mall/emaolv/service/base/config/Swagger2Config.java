package com.mall.emaolv.service.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


/**
 * @author ：Xiao Hei
 * @description：swagger2config
 * @date ：Created in 2021/10/22 16:00
 */

@EnableSwagger2
@Configuration
public class Swagger2Config {

    @Bean
    public Docket adminApi() {
        // 构造函数传入初始化规范，这是swagger2规范
        return new Docket(DocumentationType.SWAGGER_2)
                //apiInfo： 添加api详情信息，参数为ApiInfo类型的参数，这个参数包含了第二部分的所有信息比如标题、描述、版本之类的，开发中一般都会自定义这些信息
                .apiInfo(adminApiInfo())
                .groupName("admin")
                //配置是否启用Swagger，如果是false，在浏览器将无法访问，默认是true
                .enable(true)
                .select()
                //apis： 添加过滤条件,
                .apis(RequestHandlerSelectors.basePackage("com.mall.emaolv.service.edu.controller.admin"))
                //paths： 这里是控制哪些路径的api会被显示出来，比如下方的参数就是除了/user以外的其它路径都会生成api文档
                .paths((String a) ->
                        !a.equals("/user"))
                .build();
    }
        @Bean
        public Docket webApi(){
            // 构造函数传入初始化规范，这是swagger2规范
            return new Docket(DocumentationType.SWAGGER_2)
                    //apiInfo： 添加api详情信息，参数为ApiInfo类型的参数，这个参数包含了第二部分的所有信息比如标题、描述、版本之类的，开发中一般都会自定义这些信息
                    .apiInfo(webApiInfo())
                    .groupName("web")
                    //配置是否启用Swagger，如果是false，在浏览器将无法访问，默认是true
                    .enable(true)
                    .select()
                    //apis： 添加过滤条件,
                    .apis(RequestHandlerSelectors.basePackage("com.mall.emaolv.service.edu.controller.web"))
                    //paths： 这里是控制哪些路径的api会被显示出来，比如下方的参数就是除了/user以外的其它路径都会生成api文档
                    .paths((String a) ->
                            !a.equals("/user"))
                    .build();
        }

    private ApiInfo adminApiInfo() {
        Contact contactAdminDev = new Contact("小黑", "https://www.54tester.com/", "233103498@qq.com");
        return new ApiInfo(
                "在线教育后台管理",
                "负责讲师和课程管理",
                "版本内容：v1.0",
                "链接：http://terms.service.url/",
                contactAdminDev,
                "许可：Apach 2.0 ",
                "许可链接：XXX",
                new ArrayList<>()
        );
    }
        private ApiInfo webApiInfo(){
            Contact contactWebDev = new Contact("小黑", "https://www.54tester.com/", "233103498@qq.com");
            return new ApiInfo(
                    "在线教育前台管理",
                    "负责讲师和课程展示管理",
                    "版本内容：v1.0",
                    "链接：http://terms.service.url/",
                    contactWebDev,
                    "许可：Apach 2.0 ",
                    "许可链接：XXX",
                    new ArrayList<>()
            );
        }

}
