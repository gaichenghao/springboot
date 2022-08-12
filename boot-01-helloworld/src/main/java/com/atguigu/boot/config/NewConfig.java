package com.atguigu.boot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author gaich
 * @date 2022/5/19
 * @apiNote
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "myconfig")
public class NewConfig {

    public String address;
}
