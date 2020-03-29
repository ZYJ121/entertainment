package com.entertainment.test.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description  
 * @Author  zhouyanjie
 * @Date 2020-03-28 
 */

@Data
@Entity
@Table ( name ="order_spec" )
public class OrderSpecEntity  implements Serializable {

	private static final long serialVersionUID =  3011961492371273661L;

	@Id
   	@Column(name = "id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * 规格ID
	 */
   	@Basic
	@Column(name = "spec_id" )
	private int specId;

	/**
	 * 订单ID
	 */
   	@Basic
	@Column(name = "order_id" )
	private int orderId;

	/**
	 * 规格数量
	 */
   	@Basic
	@Column(name = "num" )
	private int num;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSpecId() {
		return this.specId;
	}

	public void setSpecId(int specId) {
		this.specId = specId;
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
