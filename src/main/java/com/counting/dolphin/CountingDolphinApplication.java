package com.counting.dolphin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
@MapperScan("com.counting.**")
public class CountingDolphinApplication {
    public static void main(String[] args) {
        SpringApplication.run(CountingDolphinApplication.class, args);
    }
}
