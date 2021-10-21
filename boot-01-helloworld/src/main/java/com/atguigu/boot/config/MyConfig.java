package com.atguigu.boot.config;


import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Car;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理bean方法
 *  Full(proxyBeanMethods = true)
 *  Lite(proxyBeanMethods = false)
 *  解决组件依赖
 *
 *  4\@Import({User.class, DBHelper.class})
 *  给容器中自动创建出这两种类型的组件,默认组件的名字就是全类名
 *  5\@ImportResource("classpath:beans.xml") 导入Spring的配置文件
 * */
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)//告诉SpringBoot这是一个配置类 ==配置文件
//@ConditionalOnBean(name="tom") //有tom才会注册
@ConditionalOnMissingBean(name="tom")
@ImportResource("classpath:beans.xml")
@EnableConfigurationProperties(Car.class)
//1、开始Car配置绑定功能
//2、把这个Car这个组件自动注册到容器中
public class MyConfig {


    /**
     * 外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例
     * */
//    @ConditionalOnBean(name="tom")
    @Bean//给容器中添加组件。以方法名作为组件的id,返回类型就是组件类型。返回的值，及时组件在容器中的实例
    public User user01(){
        User zhangsan = new User("zhangsan", 18);
        //user组件依赖了Pet组件
        zhangsan.setPet(pet01());
//        return new User("zhangsan",18);
        return zhangsan;
    }

//    @Bean("tom")
    public Pet pet01(){
        return new Pet("Tomcat");
    }

    @Bean("tom22")
    public Pet pet02(){
        return new Pet("Tomcat");
    }

//    @Bean
//    public CharacterEncodingFilter filter(){
//        return null;
//    }

}
