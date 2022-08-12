package com.cbf.springbootdb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cbf.springbootdb.bean.Book;
import org.apache.ibatis.annotations.Mapper;

public interface BookMapper extends BaseMapper<Book> {

    public Book getBook(Long user_id);
}
