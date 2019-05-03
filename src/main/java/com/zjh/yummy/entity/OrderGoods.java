package com.zjh.yummy.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * 订单表
 *
 * @author zjh
 * @since 2019-03-29
 */
public class OrderGoods implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    private Integer id;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 餐馆
     */
    private Integer restaurantId;
    /**
     * 餐馆
     */
    private String restaurantName;
    /**
     * 用户
     */
    private Integer userId;
    /**
     * 用户
     */
    private String userName;
    /**
     * 菜品
     */
    private Integer goodsId;
    /**
     * 菜品
     */
    private String goodsName;
    /**
     * 价格
     */
    private BigDecimal price;
    private Integer userAddressId;
    /**
     * 地址
     */
    private String userAddressName;
    /**
     * 状态 1提交订单 2支付完成 3已发货 4确认收货 5退订 6取消 7自动取消
     */
    private String status;
    /**
     * 用户收入
     */
    private BigDecimal userIn;
    /**
     * 平台收入
     */
    private BigDecimal adminIn;
    /**
     * 餐厅收入
     */
    private BigDecimal restaurantIn;
    /**
     * 预约时间
     */
    private Date subscribeTime;
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getUserAddressId() {
        return userAddressId;
    }

    public void setUserAddressId(Integer userAddressId) {
        this.userAddressId = userAddressId;
    }

    public String getUserAddressName() {
        return userAddressName;
    }

    public void setUserAddressName(String userAddressName) {
        this.userAddressName = userAddressName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getUserIn() {
        return userIn;
    }

    public void setUserIn(BigDecimal userIn) {
        this.userIn = userIn;
    }

    public BigDecimal getAdminIn() {
        return adminIn;
    }

    public void setAdminIn(BigDecimal adminIn) {
        this.adminIn = adminIn;
    }

    public BigDecimal getRestaurantIn() {
        return restaurantIn;
    }

    public void setRestaurantIn(BigDecimal restaurantIn) {
        this.restaurantIn = restaurantIn;
    }

    public Date getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Date subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "OrderGoods{" +
        "id=" + id +
        ", orderNo=" + orderNo +
        ", restaurantId=" + restaurantId +
        ", restaurantName=" + restaurantName +
        ", userId=" + userId +
        ", userName=" + userName +
        ", goodsId=" + goodsId +
        ", goodsName=" + goodsName +
        ", price=" + price +
        ", userAddressId=" + userAddressId +
        ", userAddressName=" + userAddressName +
        ", status=" + status +
        ", userIn=" + userIn +
        ", adminIn=" + adminIn +
        ", restaurantIn=" + restaurantIn +
        ", subscribeTime=" + subscribeTime +
        ", createTime=" + createTime +
        "}";
    }
}
