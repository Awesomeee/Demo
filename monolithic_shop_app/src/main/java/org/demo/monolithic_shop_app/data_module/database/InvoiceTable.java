package org.demo.monolithic_shop_app.data_module.database;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Invoices")
public class InvoiceTable {
	
	@Id
	private String invoiceId;
	@OneToOne
	@JoinColumn(name = "orderId")
	private OrderTable order;
	@Column
	private String transferedPerson;
	@Column
	private String receivedPerson;
	@Column
	private String documentClass;
	@Column
	private String documentName;
	@Column
	private LocalDateTime createdDateTime;
	@Column
	private String place;		//địa điểm
	@Column
	private String createdPerson;
	@Column
	private String approvedPerson;
	@Column
	private String content;
	
	public InvoiceTable() {}
	
	public InvoiceTable(String invoiceId, OrderTable order, String transferedPerson, String receivedPerson
			,String documentClass, String documentName, LocalDateTime createdDateTime, String place
			, String createdPerson, String approvedPerson, String content) {
		this.invoiceId = invoiceId;
		this.order = order;
		this.transferedPerson = transferedPerson;
		this.receivedPerson = receivedPerson;
		this.documentClass = documentClass;
		this.documentName = documentName;
		this.createdDateTime = createdDateTime;
		this.place = place;
		this.createdPerson = createdPerson;
		this.approvedPerson = approvedPerson;
		this.content = content;
	}	
	public String getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
	public OrderTable getOrder() {
		return order;
	}
	public void setOrderId(OrderTable order) {
		this.order = order;
	}
	public String getTransferedPerson() {
		return transferedPerson;
	}
	public void setTransferedPerson(String transferedPerson) {
		this.transferedPerson = transferedPerson;
	}
	public String getReceivedPerson() {
		return receivedPerson;
	}
	public void setReceivedPerson(String receivedPerson) {
		this.receivedPerson = receivedPerson;
	}
	public String getDocumentClass() {
		return documentClass;
	}
	public void setDocumentClass(String documentClass) {
		this.documentClass = documentClass;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getCreatedPerson() {
		return createdPerson;
	}
	public void setCreatedPerson(String createdPerson) {
		this.createdPerson = createdPerson;
	}
	public String getApprovedPerson() {
		return approvedPerson;
	}
	public void setApprovedPerson(String approvedPerson) {
		this.approvedPerson = approvedPerson;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
