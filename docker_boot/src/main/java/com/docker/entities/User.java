package com.docker.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String username;

    private String password;

    private Byte sex;

    private Byte deleted;

    private Date updateTime;

    private Date createTime;

    public User() {
    }

    public User(Integer id, String username, String password, Byte sex, Byte deleted, Date updateTime, Date createTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.deleted = deleted;
        this.updateTime = updateTime;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}