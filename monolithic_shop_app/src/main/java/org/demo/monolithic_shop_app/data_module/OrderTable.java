package org.demo.monolithic_shop_app.data_module;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class OrderTable {
	
	@Id
	private String orderId;
	@Column
	private Date createdDate;
	@Column
	private String createdPerson;	//employeeId
	@Column
	private String customer;		//customerId
	@Column
	private long beforeTaxTotal;		//tổng tiền trước thuế
	@Column
	private float taxRatio;
	@Column
	private long afterTaxTotal;		//tổng tiền sau thuế
	@Column
	private String currency;
	
	public OrderTable() {}
	
	public OrderTable(String orderId, Date createdDate, String createdPerson, String customer, long beforeTaxTotal
			, float taxRatio, long afterTaxTotal, String currency) {
		this.orderId = orderId;
		this.createdDate = createdDate;
		this.createdPerson = createdPerson;
		this.customer = customer;
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
	public String getCreatedPerson() {
		return createdPerson;
	}
	public void setCreatedPerson(String createdPerson) {
		this.createdPerson = createdPerson;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
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

}
