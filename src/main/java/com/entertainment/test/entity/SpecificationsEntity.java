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
@Table ( name ="specifications" )
public class SpecificationsEntity  implements Serializable {

	private static final long serialVersionUID =  3223306871182760554L;

	@Id
   	@Column(name = "id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * 规格名
	 */
   	@Basic
	@Column(name = "name" )
	private String name;

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

	public float getBottomPrice() {
		return this.bottomPrice;
	}

	public void setBottomPrice(float bottomPrice) {
		this.bottomPrice = bottomPrice;
	}

	public float getPaintPrice() {
		return this.paintPrice;
	}

	public void setPaintPrice(float paintPrice) {
		this.paintPrice = paintPrice;
	}

	public float getSumPrice() {
		return this.sumPrice;
	}

	public void setSumPrice(float sumPrice) {
		this.sumPrice = sumPrice;
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
