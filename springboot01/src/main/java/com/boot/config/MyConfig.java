package com.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.boot.bean.Car;
import com.boot.bean.Pet;
import com.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 1.配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2.配置类本身也是组件
 * 3.proxyBeanMethods:代理bean的方法，在springboot2中默认是true
 * Full(proxyBeanMethods = true),
 * Lite(proxyBeanMethods = false)
 * 组件依赖
 * <p>
 * 4.@Import({User.class, DBHelper.class})
 * 给容器中自动创建出这两个类型的组件，默认组件的名字就是 全类名
 */

@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)  //告诉Springboot这个是个配置类 == 配置文件

//1、开启Car配置绑定功能
//2、把这个Car这个组件自动注册到容器中
@EnableConfigurationProperties(Car.class)

public class MyConfig {

    /**
     * 外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     *
     * @return
     */
    //@ConditionalOnBean(name = "tom")    //容器有指定的组件的时候才执行
    @ConditionalOnMissingBean(name = "tom22")   //容器中没有指定的组件的时候才执行
    @Bean //给容器添加组件，以 方法名 作为组件的id，返回类型就是组件的类型。返回的值，就是组件在容器中的实例
    public User user01() {
        return new User("zhangsan", 18);
    }

    //    @Bean("tom") //如果不想方法名做id ，可以@Bean("xxx")自定义；
    public Pet tomcatPet() {
        return new Pet("tomcat");
    }
}
