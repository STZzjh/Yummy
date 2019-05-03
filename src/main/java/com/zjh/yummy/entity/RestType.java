package com.zjh.yummy.entity;

import java.io.Serializable;

/**
 * 餐厅类型
 *
 * @author zjh
 * @since 2019-03-28
 */
public class RestType implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 分类名称
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
        return "RestType{" +
        "id=" + id +
        ", name=" + name +
        ", intro=" + intro +
        "}";
    }
}
