package com.cbf.springbootdb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cbf.springbootdb.bean.Book;

import java.util.List;

public interface BookService extends IService<Book> {



    public Book getBook(Long userid);

    List<Book> getAll();
}
