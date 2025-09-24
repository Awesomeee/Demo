package org.demo.monolithic_shop_app.business_module.shop;

import org.demo.monolithic_shop_app.business_module.workshop.Product;

public class OrderItem {
	
	private int number;
	private Product product;
	//so luong
	private int quanity;
	//thanh tien
	private long amount;
	
	public OrderItem() {}
	
	public OrderItem(int number, Product product, int quantity, long amount) {
		this.number = number;
		this.product = product;
		this.quanity = quantity;
		this.amount = amount;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
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
