package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 创建人:楚克旺
 * 创建时间:2022/1/11 9:12
 **/
@SpringBootApplication
@EnableSwagger2
@EnableFeignClients
@ComponentScan(basePackages = {"com.example.edu"})
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
