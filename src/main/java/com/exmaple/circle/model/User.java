package com.exmaple.circle.model;

public class User {
    //用户id
    private Integer id;
    //用户名
    private String name;
    //用户密码
    private String password;
    //账号状态(禁用【1】/离线【2】/在线【3】)
    private Integer status;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
