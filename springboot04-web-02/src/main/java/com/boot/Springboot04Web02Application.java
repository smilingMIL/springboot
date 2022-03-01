package com.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.boot.mapper") //简化，其他的接口就可以不用标注@Mapper注解
@ServletComponentScan(basePackages = "com.boot")
@SpringBootApplication(exclude = RedisAutoConfiguration.class)//禁用redis自动配置
public class Springboot04Web02Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot04Web02Application.class, args);
    }

}
