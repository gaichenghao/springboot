package com.atguigu.boot05webadmin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    /**
     * 来登录页
     * @Return
     * */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main( String userName, String password){

            //登录成功重定向到main.html 重定向防止表单重复提交
            return "redirect:/main.html";

    }

    @GetMapping("/main.html")
    public String mainPage(){

        return "aaa";
    }
}
