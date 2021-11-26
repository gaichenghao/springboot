package com.cbf.springbootdb;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class SpringbootdbApplicationTests {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() {

        String sql="select count(*) from t_book where 1=1";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        log.info("记录总数：{}",integer);
        System.out.println(integer);

        log.info("数据源类型：{}",dataSource.getClass());
    }

}
