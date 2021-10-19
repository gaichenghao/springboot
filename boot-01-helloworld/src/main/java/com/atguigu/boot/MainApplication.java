package com.atguigu.boot;


import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import com.atguigu.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 主程序类 主配置类
 *1\ @SpringBootApplication：这是一个springboot应用
 *
 * */
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("com.atguigu")
@SpringBootApplication(scanBasePackages = "com.atguigu")
public class MainApplication {


    public static void main(String[] args) {

        //1\返回我们ioc的容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //2\查看容器里面的组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for(String name:beanDefinitionNames){
            System.out.println(name);
        }
        //3\从容器中获取组件
//        Pet tom01 = run.getBean("tom", Pet.class);
//
//        Pet tom02 = run.getBean("tom", Pet.class);
//
//        System.out.println("组件："+(tom01==tom02));
//
//        MyConfig bean = run.getBean(MyConfig.class);
//        System.out.println(bean);
//
//
//        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法，SpringBoot总会检查这个组件是否在容器中有。、
//        //保持组件单实例
//        User user1 = bean.user01();
//        User user2 = bean.user01();
//
//        System.out.println("组件user："+(user1==user2));
//        Pet pet = bean.pet01();
//
//        User user01 = run.getBean("user01", User.class);
//        Pet tom = run.getBean("tom", Pet.class);
//        System.out.println("用户的宠物："+(user01.getPet()==tom));
//        System.out.println("----------------------------------");
//        //5\获取组件
//        String[] beanUser = run.getBeanNamesForType(User.class);
//        for(String name:beanUser){
//            System.out.println(name);
//        }
//
//        beanUser = run.getBeanNamesForType(DBHelper.class);
//        for(String name:beanUser){
//            System.out.println(name);
//        }
        boolean tom = run.containsBean("tom");
        System.out.println("容器中tom组件:"+tom);

        boolean user01 = run.containsBean("user01");
        System.out.println("容器中user01组件:"+user01);

        boolean tom2 = run.containsBean("tom22");
        System.out.println("容器中tom22组件:"+tom2);

        boolean haha = run.containsBean("haha");
        System.out.println("容器中haha组件:"+haha);
        boolean hehe = run.containsBean("hehe");
        System.out.println("容器中hehe组件:"+hehe);


    }


}
