package com.atguigu.boot.controller;


import com.atguigu.boot.bean.Car;
import com.atguigu.boot.config.NewConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


//@ResponseBody
//@Controller
/**
 * @RestController 是@ResponseBody @Controller的合体
 * */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    Car car;

    @Autowired
    NewConfig newConfig;

    @RequestMapping("/car")
    public Car car(){
        return car;
    }


    @ResponseBody
    @RequestMapping("/hello")
    public String handle01(@RequestParam("name") String name){

        log.info("请求进来了");
        System.out.println(newConfig.address);
        return "hello,Spring Boot 2"+name;

    }

}
