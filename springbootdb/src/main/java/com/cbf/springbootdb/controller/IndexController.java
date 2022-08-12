package com.cbf.springbootdb.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cbf.springbootdb.bean.Book;
import com.cbf.springbootdb.service.impl.BookServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
public class IndexController {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    BookServiceImpl bookService;

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        String sql="select count(*) from t_book where 1=1";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        return integer.toString();
    }

    @ResponseBody
    @GetMapping("/getBook")
    public Book getBook(@RequestParam("userid") Long userid){
        return bookService.getBook(userid);
    }

    @ResponseBody
    @GetMapping("/getAll")
    public List<Book> getBook(){
        return bookService.getAll();
    }

    @ResponseBody
    @GetMapping("/getList")
    public List<Book> getAll(){


        Page<Book> bookPage = new Page<>(1,2);
        Page<Book> page = bookService.page(bookPage, null);



        //bookService.list();
        return page.getRecords();
    }


}
