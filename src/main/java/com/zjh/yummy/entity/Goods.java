package com.zjh.yummy.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * 菜单
 *
 * @author zjh
 * @since 2019-03-28
 */
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    private Integer id;
    /**
     * 菜名
     */
    private String name;
    /**
     * 餐厅
     */
    private Integer restaurantId;
    /**
     * 餐厅
     */
    private String restaurantName;
    /**
     * 介绍
     */
    private String intro;
    /**
     * 图片
     */
    private String headImg;
    /**
     * 标价
     */
    private BigDecimal price;
    /**
     * 实际价格
     */
    private BigDecimal currPrice;
    /**
     * 分类
     */
    private Integer typeId;
    /**
     * 分类
     */
    private String typeName;
    /**
     * 类型 1单品 2套餐
     */
    private String clazz;
    /**
     * 总量
     */
    private Integer number;
    /**
     * 剩余
     */
    private Integer shengyuNumber;
    /**
     * 菜单时效开始
     */
    private Date startDate;
    /**
     * 菜单时效结束
     */
    private Date endDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCurrPrice() {
        return currPrice;
    }

    public void setCurrPrice(BigDecimal currPrice) {
        this.currPrice = currPrice;
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

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getShengyuNumber() {
        return shengyuNumber;
    }

    public void setShengyuNumber(Integer shengyuNumber) {
        this.shengyuNumber = shengyuNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    @Override
    public String toString() {
        return "Goods{" +
        "id=" + id +
        ", name=" + name +
        ", restaurantId=" + restaurantId +
        ", restaurantName=" + restaurantName +
        ", intro=" + intro +
        ", headImg=" + headImg +
        ", price=" + price +
        ", currPrice=" + currPrice +
        ", typeId=" + typeId +
        ", typeName=" + typeName +
        ", clazz=" + clazz +
        ", number=" + number +
        ", shengyuNumber=" + shengyuNumber +
        ", startDate=" + startDate +
        ", endDate=" + endDate +
        "}";
    }
}
