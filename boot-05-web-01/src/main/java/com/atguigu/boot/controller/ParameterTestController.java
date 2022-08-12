package com.atguigu.boot.controller;


import com.atguigu.boot.bean.Person;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {


    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String name,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,String> heads,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("inters")List<String> inters,
                                     @RequestParam Map<String,String> maps,
                                     @CookieValue("TopicAddress") String topicAddress,
                                     @CookieValue("TopicAddress") Cookie cookie){
        Map<String,Object> map=new HashMap<>();
//        map.put("id",id);
//        map.put("username",name);
//        map.put("pv",pv);
//        map.put("userAgent",userAgent);
//        map.put("heads",heads);
        map.put("age",age);
        map.put("inters",inters);
        map.put("maps",maps);
        map.put("topicAddress",topicAddress);
        map.put("cookie",cookie);
        return map;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){
        Map<String,Object> map=new HashMap<>();
        map.put("content",content);
        return map;

    }


    //1.语法"/car/sell;low=34;brand=byd,audi,yd"
    //2.SpringBoot默认是禁用了矩阵变量的功能
    //3.手动开启：原理。对于路径的处理。UrlPathHelper 进行解析。
    //removeSemicolonContent(移除分号内容) 支持矩阵变量的
    //3、矩阵变量必须有url路径才能被解析
    @GetMapping("/car/{path}")
    public Map carsSell(@MatrixVariable Integer low,
                        @MatrixVariable List<String> brand,
                        @PathVariable("path") String path){
        Map<String,Object> map=new HashMap<>();
        map.put ("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }

    //"/boss/1;age=20/2;age=10"
    @GetMapping("/boss/{bossId}/{empId}")
    public Map  boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age",pathVar = "empId") Integer empAge){
        Map<String,Object> map=new HashMap<>();
        map.put("bossAge",bossAge);
        map.put("empAge",empAge);
        return map;
    }


    /**
     * 数据绑定：页面提交的请求数据（get post）都可以和对象属性进行绑定
     * */
    @PostMapping("/saveuser")
    public Person saveuser(Person person){
        return  person;
    }



}
