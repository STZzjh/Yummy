package com.zjh.yummy.entity;

import java.io.Serializable;

/**
 * 套餐详情
 *
 * @author zjh
 * @since 2019-03-28
 */
public class GoodsGoods implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 套餐ID
     */
    private Integer goodsId;

    /**
     * 套餐栏目
     */
    private Integer subgoodsId;

    /**
     * 套餐栏目
     */
    private String subgoodsName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getSubgoodsId() {
        return subgoodsId;
    }

    public void setSubgoodsId(Integer subgoodsId) {
        this.subgoodsId = subgoodsId;
    }

    public String getSubgoodsName() {
        return subgoodsName;
    }

    public void setSubgoodsName(String subgoodsName) {
        this.subgoodsName = subgoodsName;
    }


    @Override
    public String toString() {
        return "GoodsGoods{" +
        "id=" + id +
        ", goodsId=" + goodsId +
        ", subgoodsId=" + subgoodsId +
        ", subgoodsName=" + subgoodsName +
        "}";
    }
}
