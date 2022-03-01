package com.boot.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString//toString方法
@Data//get，set方法
@NoArgsConstructor//无参构造
@AllArgsConstructor//带参构造
public class User {

    private String name;
    private Integer age;


}
