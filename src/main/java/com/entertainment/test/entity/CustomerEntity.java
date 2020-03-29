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
@Table ( name ="customer" )
public class CustomerEntity  implements Serializable {

	private static final long serialVersionUID =  8951157555928382993L;

	@Id
   	@Column(name = "id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * 客户名
	 */
   	@Basic
	@Column(name = "name" )
	private String name;

	/**
	 * 安装地点
	 */
   	@Basic
	@Column(name = "place" )
	private String place;

	/**
	 * 未结款项
	 */
   	@Basic
	@Column(name = "unfinished__price" )
	private Double unfinishedPrice;

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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Double getUnfinishedPrice() {
		return this.unfinishedPrice;
	}

	public void setUnfinishedPrice(Double unfinishedPrice) {
		this.unfinishedPrice = unfinishedPrice;
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
