package com.example.boot05webadmin24.controller;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


/**
 * 文件上传测试
 */
@Controller
@Slf4j
public class FormTestController {

    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    /**
     * MultipartFile自动封装上传过来的文件
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {

        log.info("上传的信息：email={},username={},headimg={},photos={}",email,username,headerImg.getSize(),photos.length);

        if(!headerImg.isEmpty()){
            //保存到文件服务器，oss服务器
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("H:\\"+originalFilename));
        }
        if(photos.length>0){
            for (MultipartFile photo:photos){
                if(!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("H:\\"+originalFilename));
                }
            }
        }

        return "main";
    }


    //接口  animal eat() name()
    //父类  animal eat(){ sout("吃东西") } name() {return "animal"}
    //map "cat" Cat eat(){ sout("吃鱼")} name {return "cat"}
    //mao "dog" Dog eat(){ sout("吃骨头")}  name {return "dog"}
    //Animal animal = new Cat()/new Dog()/new Animal() get(String)；
    //animal.eat();

    @Test
    public void test(){
        animal animal=new dog();
        animal.eat();
    }

    public interface animal{
        public void eat();
    }
    public class dog implements animal{

        @Override
        public void eat() {
            System.out.println("狗吃肉");
        }
    }
    public class cat implements animal{

        @Override
        public void eat() {
            System.out.println("猫吃鱼");
        }
    }




}
