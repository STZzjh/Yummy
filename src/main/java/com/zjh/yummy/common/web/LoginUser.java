package com.zjh.yummy.common.web;

public class LoginUser {

    private Integer id;
    private String username;
    private String role;
    private String showname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getShowname() {
        return showname;
    }

    public void setShowname(String showname) {
        this.showname = showname;
    }
}
