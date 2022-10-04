package com.zhu;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author xiaozhu
 * @date 2022年10月03日 23:12                          $
 */

@SpringBootApplication
@MapperScan("com.zhu.mapper")
@EnableScheduling
@EnableSwagger2
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.LOG);
        app.run(args);
    }
}
