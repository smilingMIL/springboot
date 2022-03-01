package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

@SpringBootApplication
public class Springboot06ProfileApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Springboot06ProfileApplication.class, args);

        //获取系统的环境变量
        ConfigurableEnvironment environment = run.getEnvironment();

        Map<String, Object> systemEnvironment = environment.getSystemEnvironment();

        Map<String, Object> systemProperties = environment.getSystemProperties();

        System.out.println(systemEnvironment);
        System.out.println(systemProperties);
    }

}
