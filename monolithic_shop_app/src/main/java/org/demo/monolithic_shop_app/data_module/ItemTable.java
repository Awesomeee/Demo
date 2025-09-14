package org.demo.monolithic_shop_app.data_module;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Items")
public class ItemTable {
	
	@Id
	private String itemId;
	@ManyToOne
	@JoinColumn(name = "orderId")
	private OrderTable order;
	@ManyToOne
	@JoinColumn(name = "productId")
	private ProductTable product;
	@Column
	private int number;
	//so luong
	@Column
	private int quanity;
	//thanh tien
	@Column
	private long amount;
	
	public ItemTable() {}
	
	public ItemTable(String itemId, OrderTable order, ProductTable product, int number, int quantity, long amount) {
		this.itemId = itemId;
		this.order = order;
		this.product = product;
		this.number = number;
		this.quanity = quantity;
		this.amount = amount;
	}
	
	public String getItemId() {
		return itemId;
	}
	public void setRelationId(String itemId) {
		this.itemId = itemId;
	}
	public OrderTable getOrder() {
		return order;
	}
	public void setOrder(OrderTable order) {
		this.order = order;
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

	public ProductTable getProduct() {
		return product;
	}

	public void setProduct(ProductTable product) {
		this.product = product;
	}

}
