package com.eloancn.test.model;

import java.io.Serializable;

/**
 * Created by eloancn on 2018/5/29.
 */
public class ApplicationParam  implements Serializable{
    // 应用名称
    private String               name;

    // 模块版本
    private String               version;

    // 应用负责人
    private String               owner;

    // 组织名(BU或部门)
    private String               organization;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
