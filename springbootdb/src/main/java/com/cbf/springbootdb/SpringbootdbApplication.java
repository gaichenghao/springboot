package com.cbf.springbootdb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.cbf.springbootdb.mapper")
@ServletComponentScan(basePackages = "xom.atguigu.admin")
@SpringBootApplication
public class SpringbootdbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdbApplication.class, args);
    }

}
