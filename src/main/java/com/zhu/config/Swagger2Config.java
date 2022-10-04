package com.zhu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 // 开启Swagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        // 配置一个Docket
        return new Docket(DocumentationType.SWAGGER_2) // DocumentationType 即文档类型的选择我们需要根据集成的 Swagger 的版本来选择，这里选择 SWAGGER_2 表示使用的 Swagger 是2.X系列版本。
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zhu.controller")) //为当前包下controller生成API文档
                // .apis(RequestHandlerSelectors.withClassAnnotation(Api.class)) //为有@Api注解的Controller生成API文档
                // .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)) //为有@ApiOperation注解的方法生成API文档
                .paths(PathSelectors.any()) // 将项目中所有接口的请求路径都暴露给 Swagger 来生成 Swagger-UI 界面
                .build()
                .apiInfo(
                        new ApiInfoBuilder()
                                .title("API测试文档") // Swagger-UI 界面的大标题
                                .description("springboot_framework项目") //  Swagger-UI 界面的一些简单描述信息
                                .contact(new Contact("xiaozhu", "https://github.com/XIAOZHUXUEJAVA/", "xiaozhuzhulzq@163.com"))
                                .version("1.0") // 界面上所有接口的版本
                                .license("Apache2.0")
                                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                                .build()
                ); // 在apiInfo中构建文档的基本信息
    }

}
