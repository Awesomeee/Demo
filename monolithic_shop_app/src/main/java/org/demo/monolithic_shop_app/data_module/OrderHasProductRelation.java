package org.demo.monolithic_shop_app.data_module;

import org.demo.monolithic_shop_app.business_module.Product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrderHasProductRelation")
public class OrderHasProductRelation {
	
	@Id
	private String relationId;
	@Column
	private String orderId;
	@Column
	private String productId;
	@Column
	private int number;
	//so luong
	@Column
	private int quanity;
	//thanh tien
	@Column
	private long amount;
	
	public OrderHasProductRelation() {}
	
	public OrderHasProductRelation(String relationId, String orderId, String productId, int number, int quantity, long amount) {
		this.relationId = relationId;
		this.orderId = orderId;
		this.productId = productId;
		this.number = number;
		this.quanity = quantity;
		this.amount = amount;
	}
	
	public String getRelationId() {
		return relationId;
	}
	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getQuanity() {
		return quanity;
	}
	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}

}
