package com.entertainment.test.entity;


import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author yaojunguang
 * create time: Fri Jan 17 10:58:12 CST 2020.
 */

@Data
@Entity
@Table(name = "menu")
public class MenuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name")
    //("导航栏显示名称")
    private String name;

    @Basic
    @Column(name = "url")
    //("跳转链接")
    private String url;

    @Basic
    @Column(name = "parent_id")
    //("父级ID")
    private Integer parentId;

    @Basic
    @Column(name = "state")
    //("0为不显示，1为显示")
    private Byte state;

    @Basic
    @Column(name = "icon")
    //("导航图标")
    private String icon;

    @Basic
    @Column(name = "sort")
    //("排序")
    private Integer sort;

    @Basic
    @Column(name = "create_time")
    private Timestamp createTime;

    @Basic
    @Column(name = "update_time")
    private Timestamp updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
