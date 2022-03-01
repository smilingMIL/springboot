package com.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 只有在容器中的组件，才会拥有springboot提供的强大功能
 */

@ToString//toString方法
@Data//get，set方法
@NoArgsConstructor//无参构造
@AllArgsConstructor//带参构造

@Component
@ConfigurationProperties(prefix = "mycar")
public class Car {

    private String brand;
    private Integer price;


}
