package com.eloancn.test.model;

import java.io.Serializable;

/**
 * Created by eloancn on 2018/5/29.
 */
public class RegistryParam implements Serializable {

    // 注册中心地址
    private String address;

    // 注册中心登录用户名
    private String username;

    // 注册中心登录密码
    private String password;

    // 注册中心缺省端口
    private Integer port;

    // 注册中心协议
    private String protocol;

    private String id;

    private Integer timeout;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
}
