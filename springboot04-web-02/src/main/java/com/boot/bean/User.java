package com.boot.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("user")  //如果javabean的类名不和数据库的对应表名不一样就要加上@TableName()来实现对应操作表
public class User {

    /**
     * mybatis-plus所有属性都应该在数据库中有
     */


    @TableField(exist = false)  //标识这个属性在数据库中不存在，不要管我就行
    private String userName;
    @TableField(exist = false)
    private String password;


    //以下是数据库的数据
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
