package com.cbf.springbootdb.controller;


import com.cbf.springbootdb.bean.Book;
import com.cbf.springbootdb.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class IndexController {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    BookService bookService;

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


}
