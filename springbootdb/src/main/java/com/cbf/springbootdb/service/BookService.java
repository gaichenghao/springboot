package com.cbf.springbootdb.service;


import com.cbf.springbootdb.bean.Book;
import com.cbf.springbootdb.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookMapper bookMapper;

    public Book getBook(Long userid){
        return bookMapper.getBook(userid);
    }

}
