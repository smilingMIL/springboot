package com.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.docker.mapper") //import tk.mybatis.spring.annotation.MapperScan;
public class DockerBootMain {

    public static void main(String[] args) {
        SpringApplication.run(DockerBootMain.class, args);
    }
}
