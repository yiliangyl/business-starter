package com.qyl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qyl.mapper")
public class BusinessStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessStarterApplication.class, args);
    }

}
