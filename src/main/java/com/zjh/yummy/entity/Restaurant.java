package com.zjh.yummy.entity;

import java.io.Serializable;

/**
 * 餐馆
 *
 * @author zjh
 * @since 2019-03-29
 */
public class Restaurant implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    private Integer id;
    /**
     * 登录编号
     */
    private String loginNo;
    /**
     * 密码
     */
    private String password;
    /**
     * 统一社会信用代码
     */
    private String certNo;
    /**
     * 位置X
     */
    private Integer positionX;
    /**
     * 位置Y
     */
    private Integer positionY;
    /**
     * 名称
     */
    private String name;
    /**
     * 头像
     */
    private String headImg;
    /**
     * 分类
     */
    private Integer typeId;
    /**
     * 分类
     */
    private String typeName;
    /**
     * 地址
     */
    private String address;
    /**
     * 状态 0审批中 1正常营业 2停业整顿
     */
    private String status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginNo() {
        return loginNo;
    }

    public void setLoginNo(String loginNo) {
        this.loginNo = loginNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
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

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Restaurant{" +
        "id=" + id +
        ", loginNo=" + loginNo +
        ", password=" + password +
        ", certNo=" + certNo +
        ", positionX=" + positionX +
        ", positionY=" + positionY +
        ", name=" + name +
        ", headImg=" + headImg +
        ", typeId=" + typeId +
        ", typeName=" + typeName +
        ", address=" + address +
        ", status=" + status +
        "}";
    }
}
