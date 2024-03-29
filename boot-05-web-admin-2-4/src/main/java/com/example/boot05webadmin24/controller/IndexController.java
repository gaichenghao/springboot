package com.example.boot05webadmin24.controller;


import com.example.boot05webadmin24.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

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
    public String main(User user, HttpSession session, Model model){

        if(StringUtils.hasLength(user.getUserName()) && "123456".equals(user.getPassword())){
            //把登陆成功的用户保存起来
            session.setAttribute("loginUser",user);
        }else{
            model.addAttribute("msg","账号密码错误");
            //回到登录页面
            return "login";

        }

        //登录成功重定向到main.html 重定向防止表单重复提交
        return "redirect:/main.html";

    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){

        //是否登录 拦截器 过滤器
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser!=null){
            return "main";
        }else {
            //回到登录页面
            model.addAttribute("msg","请重新登录");
            return "login";
        }
    }

}
