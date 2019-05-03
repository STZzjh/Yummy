package com.zjh.yummy.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户地址
 *
 * @author zjh
 * @since 2019-03-29
 */
public class UserAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    private Integer id;
    /**
     * 位置X
     */
    private Integer positionX;
    /**
     * 位置Y
     */
    private Integer positionY;
    /**
     * 地址
     */
    private String name;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 联系人
     */
    private String uname;
    /**
     * 电话
     */
    private String phone;
    /**
     * 用户Name
     */
    private String userName;
    /**
     * 创建时间
     */
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "UserAddress{" +
        "id=" + id +
        ", positionX=" + positionX +
        ", positionY=" + positionY +
        ", name=" + name +
        ", userId=" + userId +
        ", uname=" + uname +
        ", phone=" + phone +
        ", userName=" + userName +
        ", createTime=" + createTime +
        "}";
    }
}
