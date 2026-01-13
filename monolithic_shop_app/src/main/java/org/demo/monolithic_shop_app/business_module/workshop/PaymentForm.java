package org.demo.monolithic_shop_app.business_module.workshop;

import java.time.LocalDateTime;

public class PaymentForm {
	
	private String paymentId;
	private String createdEmployeeId;
	private LocalDateTime createdDate;
	private LocalDateTime finishDate;
	private String orderId;
	private String paidPersonId;			//người trả - customerId
	private String receiverId;				//người nhận - employeeId
	private String note;
	private long amount;
	private String currency;
	private String paymentType;
	
	public PaymentForm() {}
	
	public PaymentForm(String paymentId, String createdEmployeeId, LocalDateTime createdDate, LocalDateTime finishDate
			, String orderId, String paidPersonId, String receiverId, String note, long amount, String currency
			, String paymentType) {
		this.paymentId = paymentId;
		this.createdEmployeeId = createdEmployeeId;
		this.createdDate = createdDate;
		this.finishDate = finishDate;
		this.orderId = orderId;
		this.paidPersonId = paidPersonId;
		this.receiverId = receiverId;
		this.note = note;
		this.amount = amount;
		this.currency = currency;
		this.paymentType = paymentType;
	}
	
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getCreatedEmployeeId() {
		return createdEmployeeId;
	}
	public void setCreatedEmployeeId(String createdEmployeeId) {
		this.createdEmployeeId = createdEmployeeId;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDateTime getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(LocalDateTime finishDate) {
		this.finishDate = finishDate;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getPaidPersonId() {
		return paidPersonId;
	}
	public void setPaidPersonId(String paidPersonId) {
		this.paidPersonId = paidPersonId;
	}
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

}
