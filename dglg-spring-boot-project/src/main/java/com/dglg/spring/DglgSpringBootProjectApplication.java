package com.dglg.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.dglg.spring.dao")
public class DglgSpringBootProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DglgSpringBootProjectApplication.class, args);
    }

}
