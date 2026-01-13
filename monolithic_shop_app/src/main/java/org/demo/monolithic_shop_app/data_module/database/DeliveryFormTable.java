package org.demo.monolithic_shop_app.data_module.database;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DeliveryForms")
public class DeliveryFormTable {
	
	@Id
	private String deliveryId;
	@Column
	private String createdEmployeeId;
	@Column
	private LocalDateTime createdDate;
	@Column
	private LocalDateTime finishDate;
	@Column
	private String orderId;
	@Column
	private String customerId;
	@Column
	private String shipperId;
	@Column
	private String note;
	@Column
	private LocalDateTime overdueDate;
	@Column
	private String state;			//REQUESTING, PROCESSING, SUSPENDED, ABORTED, FINISH_SUCCESSFULLY, FINISH_CANCEL
	
	public DeliveryFormTable() {}
	
	public DeliveryFormTable(String deliveryId, String createdEmployeeId, LocalDateTime createdDate, LocalDateTime finishDate
			, String orderId, String customerId, String shipperId, String note, LocalDateTime overdueDate
			, String state) {
		this.deliveryId = deliveryId;
		this.createdEmployeeId = createdEmployeeId;
		this.createdDate = createdDate;
		this.finishDate = finishDate;
		this.orderId = orderId;
		this.customerId = customerId;
		this.shipperId = shipperId;
		this.note = note;
		this.overdueDate = overdueDate;
		this.state = state;
	}
	
	public String getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(String deliveryId) {
		this.deliveryId = deliveryId;
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
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getShipperId() {
		return shipperId;
	}
	public void setShipperId(String shipperId) {
		this.shipperId = shipperId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public LocalDateTime getOverdueDate() {
		return overdueDate;
	}
	public void setOverdueDate(LocalDateTime overdueDate) {
		this.overdueDate = overdueDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public LocalDateTime getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(LocalDateTime finishDate) {
		this.finishDate = finishDate;
	}
}
