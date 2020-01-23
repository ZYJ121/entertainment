package com.entertainment.test.controller.menu;

import com.entertainment.test.entity.MenuEntity;

import java.util.List;

/**
 * @创建人 zhouyanjie
 * @创建时间 2020/1/23 15:06
 * @描述
 */
public class MenuCell {
//    导航栏名称
    private String name;
//    导航栏跳转地址
    private String url;
//    导航栏状态
    private Integer state;
//    导航栏图标
    private String icon;
//    导航栏的子类
    private List<MenuEntity> child;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<MenuEntity> getChild() {
        return child;
    }

    public void setChild(List<MenuEntity> child) {
        this.child = child;
    }
}
