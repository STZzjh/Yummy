package com.zjh.yummy.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 
 *
 * @author zjh
 * @since 2019-03-14
 */
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;

    private String username;

    private String password;

    private String name;

    private String intro;

    private Date createTime;


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
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "Admin{" +
        "id=" + id +
        ", username=" + username +
        ", password=" + password +
        ", name=" + name +
        ", intro=" + intro +
        ", createTime=" + createTime +
        "}";
    }
}
