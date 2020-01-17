package com.entertainment.test.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "entertainment")
//@ApiModel(description = "<a href='/web/swift/EntertainmentEntity' target=_blank>EntertainmentEntity</a>")
public class EntertainmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "male_lead")
//    @ApiModelProperty("男主")
    private String maleLead;

    @Basic
    @Column(name = "female_lead")
//    @ApiModelProperty("女主")
    private String femaleLead;

    @Basic
    @Column(name = "item_type")
//    @ApiModelProperty("类型(0-小说，1-电影，2-韩剧，3-国产剧，4-综艺）")
    private int itemType;

    @Basic
    @Column(name = "sort")
//    @ApiModelProperty("排序")
    private Integer sort = 0;

    @Basic
    @Column(name = "recommend")
//    @ApiModelProperty("推荐指数")
    private Integer recommend;

    @Basic
    @Column(name = "describe")
//    @ApiModelProperty("描述")
    private String describe;

    @Basic
    @Column(name = "reade_time")
//    @ApiModelProperty("什么时候看的")
    private Timestamp readeTime;

    @Basic
    @Column(name = "create_time")
//    @ApiModelProperty("创建时间")
    private Timestamp createTime;

    @Basic
    @Column(name = "update_time")
//    @ApiModelProperty("删除时间")
    private Timestamp updateTime;

}
