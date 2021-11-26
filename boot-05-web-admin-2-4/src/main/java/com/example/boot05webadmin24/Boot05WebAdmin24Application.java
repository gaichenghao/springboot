package com.example.boot05webadmin24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.example.boot05webadmin24")
public class Boot05WebAdmin24Application {

    public static void main(String[] args) {
        SpringApplication.run(Boot05WebAdmin24Application.class, args);
    }

}
