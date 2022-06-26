package com.chen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chen.mapper")
public class DormitorymsSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DormitorymsSpringbootApplication.class, args);
    }

}
