package com.entertainment.test.controller.order;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class OrderCell {
    /**
     * 规格名
     */
    @Basic
    @Column(name = "spec_name" )
    private String specName;

    /**
     * 做底单价
     */
    @Basic
    @Column(name = "bottom_price" )
    private float bottomPrice;

    /**
     * 面漆单价
     */
    @Basic
    @Column(name = "paint_price" )
    private float paintPrice;

    /**
     * 总价
     */
    @Basic
    @Column(name = "sum_price" )
    private float sumPrice;

    /**
     * 订单ID
     */
    @Id
    @Column(name = "id" )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 客户ID
     */
    @Basic
    @Column(name = "cust_id" )
    private int custId;

    /**
     * 客户名
     */
    @Basic
    @Column(name="cust_name")
    private String custName;
    /**
     * 订单金额
     */
    @Basic
    @Column(name = "amount" )
    private float amount;

    /**
     * 订单编号
     */
    @Basic
    @Column(name = "code" )
    private int code;

    /**
     * 是否安装（0：不安装，1安装）
     */
    @Basic
    @Column(name = "install" )
    private int install;

    /**
     * 是否紧急（同种状态下，数字越大越紧急）
     */
    @Basic
    @Column(name = "urgent" )
    private int urgent;

    /**
     * 订单状态（0：已打单，1：已发货，2：已结款）
     */
    @Basic
    @Column(name = "state" )
    private int state;

    /**
     * 备注
     */
    @Basic
    @Column(name = "describe" )
    private String describe;

    /**
     * 下单日期
     */
    @Basic
    @Column(name = "order_time" )
    private Date orderTime;

    /**
     * 完成日期
     */
    @Basic
    @Column(name = "finish_time" )
    private Date finishTime;

    /**
     * 创建时间
     */
    @Basic
    @Column(name = "create_time" )
    private Date createTime;

    /**
     * 删除时间
     */
    @Basic
    @Column(name = "update_time" )
    private Date updateTime;
}
