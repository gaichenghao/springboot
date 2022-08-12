package com.cbf.springbootdb.service.impl;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cbf.springbootdb.bean.Book;
import com.cbf.springbootdb.mapper.BookMapper;
import com.cbf.springbootdb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper,Book> implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Autowired
    BaseMapper baseMapper;

    public Book getBook(Long userid){
        return bookMapper.getBook(userid);
    }

    @Override
    public List<Book> getAll() {
        return null;
    }

}
