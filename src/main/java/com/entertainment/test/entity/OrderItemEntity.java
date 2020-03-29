package com.entertainment.test.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description  
 * @Author  zhouyanjie
 * @Date 2020-03-28 
 */

@Data
@Entity
@Table ( name ="order_item" )
public class OrderItemEntity  implements Serializable {

	private static final long serialVersionUID =  3139189201899488983L;

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
	 * 订单金额
	 */
   	@Basic
	@Column(name = "amount" )
	private float amount;

	/**
	 * 订单编号
	 */
   	@Basic
	@Column(name = "`code`" )
	private int code;

	/**
	 * 是否安装（0：不安装，1安装）
	 */
   	@Basic
	@Column(name = "`install`" )
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
	@Column(name = "`describe`" )
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

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustId() {
		return this.custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public float getAmount() {
		return this.amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getInstall() {
		return this.install;
	}

	public void setInstall(int install) {
		this.install = install;
	}

	public int getUrgent() {
		return this.urgent;
	}

	public void setUrgent(int urgent) {
		this.urgent = urgent;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getDescribe() {
		return this.describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Date getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Date getFinishTime() {
		return this.finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
