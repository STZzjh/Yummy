package com.zjh.yummy.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 订单时间
 *
 * @author zjh
 * @since 2019-03-29
 */
public class OrderTime implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 状态 1提交订单 2支付完成 3已发货 4确认收货 5退订 6取消 7自动取消
     */
    private String status;

    /**
     * 状态时间
     */
    private Date statusTime;

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(Date statusTime) {
        this.statusTime = statusTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "OrderTime{" +
        "id=" + id +
        ", orderNo=" + orderNo +
        ", status=" + status +
        ", statusTime=" + statusTime +
        ", createTime=" + createTime +
        "}";
    }
}
