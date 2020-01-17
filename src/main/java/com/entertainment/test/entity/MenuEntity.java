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

}
