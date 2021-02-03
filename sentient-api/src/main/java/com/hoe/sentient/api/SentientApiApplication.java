package com.hoe.sentient.api;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.hoe.sentient",
        exclude= DruidDataSourceAutoConfigure.class)
@MapperScan(value = "com.hoe.sentient.*.mapper")
public class SentientApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentientApiApplication.class, args);
    }

}
