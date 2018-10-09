package com.eloancn.test.model;

import java.io.Serializable;

/**
 * Created by eloancn on 2018/5/29.
 */
public class ProtocolParam implements Serializable{
    private String id;
    private String name;
    private Integer port;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
