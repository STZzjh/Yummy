package com.zjh.yummy.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * 用户
 *
 * @author zjh
 * @since 2019-03-29
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 登录名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
    private BigDecimal money;
    /**
     * 性别
     */
    private String sex;
    /**
     * 头像
     */
    private String headImg;
    /**
     * 简介
     */
    private String intro;
    /**
     * 通信地址
     */
    private String address;
    /**
     * 电话
     */
    private String phone;
    /**
     * 激活验证
     */
    private String vcode;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 状态 0未激活 1正常使用 2注销
     */
    private String status;
    /**
     * 注册时间
     */
    private Date createTime;
    /**
     * 最后更新时间
     */
    private Date updateTime;


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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", username=" + username +
        ", password=" + password +
        ", name=" + name +
        ", money=" + money +
        ", sex=" + sex +
        ", headImg=" + headImg +
        ", intro=" + intro +
        ", address=" + address +
        ", phone=" + phone +
        ", vcode=" + vcode +
        ", email=" + email +
        ", status=" + status +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
