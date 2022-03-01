package com.boot.controller;

import com.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${person.name:李四}") //从配置文件拿取数据，如果拿不到就是 冒号 后面的值
    private String name;

    @Autowired
    private Person person;

    @Value("${MAVEN_HOME}")
    private String msg;

    @Value("${os.name}")
    private String osName;

    @GetMapping("/")
    public String hello(){

        return person.getClass().toString();
    }

    @GetMapping("/person")
    public Person person(){

        return person;
    }


    @GetMapping("/msg")
    public String getMsg(){

        return msg+"==>"+osName;
    }


}
