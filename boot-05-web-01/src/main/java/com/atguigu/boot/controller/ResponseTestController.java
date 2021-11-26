package com.atguigu.boot.controller;


import com.atguigu.boot.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ResponseTestController {




    /**
     * 1、浏览器发送直接返回xml   【application/xml】   jacksonXmlConverter
     * 2、如果ajax请求，放回json  【application/json】  jacksonJsonConverter
     * 3、如果硅谷app发请求，返回自定义协议数据  【application/x-guigu】  **********Converter
     *
     *
     * 步骤：
     * 1、添加自定义的MessageConverter进系统底层
     * 2、系统底层会统计出所有MessageConverter 能操作哪些类型
     * 3、客户端内容协商【guigu-->guigu】
     * */
    @ResponseBody
    @GetMapping("/test/person")
    public Person getPerson(){
        Person person=new Person();
        person.setAge(20);
        person.setBirth(new Date());
        person.setUserName("张三");
        return person;
    }
}
