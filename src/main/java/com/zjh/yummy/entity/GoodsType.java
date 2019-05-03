package com.zjh.yummy.entity;

import java.io.Serializable;

/**
 * 菜品类型
 *
 * @author zjh
 * @since 2019-03-28
 */
public class GoodsType implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 简介
     */
    private String intro;


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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }


    @Override
    public String toString() {
        return "GoodsType{" +
        "id=" + id +
        ", name=" + name +
        ", intro=" + intro +
        "}";
    }
}
