package com.cbf.springbootdb.bean;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_book")
public class Book {
    public Long user_id;

    public String username;

    public String ustatus;

    @TableField(exist = false)
    public Integer id;

}
