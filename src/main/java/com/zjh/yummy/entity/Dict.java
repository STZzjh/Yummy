package com.zjh.yummy.entity;

import java.io.Serializable;

/**
 * 系统设置
 *
 * @author zjh
 * @since 2019-03-28
 */
public class Dict implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;

    /**
     * CODE
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 值
     */
    private String value;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Dict{" +
        "id=" + id +
        ", code=" + code +
        ", name=" + name +
        ", value=" + value +
        "}";
    }
}
