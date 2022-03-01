package com.boot;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class Springboot05AdminserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot05AdminserverApplication.class, args);
    }

}
