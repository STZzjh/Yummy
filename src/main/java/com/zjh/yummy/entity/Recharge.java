package com.zjh.yummy.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * 充值记录
 *
 * @author zjh
 * @since 2019-03-28
 */
public class Recharge implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer userId;

    private String userName;

    /**
     * 金额
     */
    private BigDecimal money;

    /**
     * 银行 1招商银行 2建设银行 3交通银行 4工商银行
     */
    private String bank;

    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "Recharge{" +
        "id=" + id +
        ", userId=" + userId +
        ", userName=" + userName +
        ", money=" + money +
        ", bank=" + bank +
        ", createTime=" + createTime +
        "}";
    }
}
