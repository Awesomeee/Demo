package org.demo.monolithic_shop_app.business_module;

import java.util.Date;
import java.util.List;

public class Order {
	
	private String orderId;
	private Date createdDate;
	private String createdPerson;	//employeeId
	private String customer;		//customerId
	private List<OrderItem> itemList;
	private long beforeTaxTotal;		//tổng tiền trước thuế
	private float taxRatio;
	private long afterTaxTotal;		//tổng tiền sau thuế
	private String currency;
	
	public Order() {}
	
	public Order(String orderId, Date createdDate, String createdPerson, String customer, List<OrderItem> itemList, long beforeTaxTotal
			, float taxRatio, long afterTaxTotal, String currency) {
		this.orderId = orderId;
		this.createdDate = createdDate;
		this.createdPerson = createdPerson;
		this.customer = customer;
		this.itemList = itemList;
		this.beforeTaxTotal = beforeTaxTotal;
		this.taxRatio = taxRatio;
		this.afterTaxTotal = afterTaxTotal;
		this.currency = currency;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public List<OrderItem> getItemList() {
		return itemList;
	}
	public void setItemList(List<OrderItem> itemList) {
		this.itemList = itemList;
	}
	public String getCreatedPerson() {
		return createdPerson;
	}
	public void setCreatedPerson(String createdPerson) {
		this.createdPerson = createdPerson;
	}
	public long getBeforeTaxTotal() {
		return beforeTaxTotal;
	}
	public void setBeforeTaxTotal(long beforeTaxTotal) {
		this.beforeTaxTotal = beforeTaxTotal;
	}
	public float getTaxRatio() {
		return taxRatio;
	}
	public void setTaxRatio(float taxRatio) {
		this.taxRatio = taxRatio;
	}
	public long getAfterTaxTotal() {
		return afterTaxTotal;
	}
	public void setAfterTaxTotal(long afterTaxTotal) {
		this.afterTaxTotal = afterTaxTotal;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}

}
