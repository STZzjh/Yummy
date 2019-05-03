package com.zjh.yummy.common.web;

public class Msg {

    private int code;
    private String msg;
    private Object data;

    public static Msg success() {
        Msg msg = new Msg();
        msg.setCode(1);
        msg.setMsg("success");
        return msg;
    }

    public static Msg error() {
        Msg msg = new Msg();
        msg.setCode(-1);
        msg.setMsg("error");
        return msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public Msg setData(Object data) {
        this.data = data;
        return this;
    }
}
