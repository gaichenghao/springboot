package com.cbf.springbootdb.mapper;

import com.cbf.springbootdb.bean.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {

    public Book getBook(Long user_id);
}
