package org.demo.monolithic_shop_app.business_module.document;

import java.time.LocalDateTime;

public class Invoice extends Document {
	
	private String invoiceId;
	private String orderId;
	private String transferedPerson;
	private String receivedPerson;
	
	public Invoice() {}
	
	public Invoice(String documentId, String documentClass, String documentName, LocalDateTime createdDateTime
			, String place, String createdPerson, String approvedPerson, String content, String invoiceId
			, String orderId, String transferedPerson, String receivedPerson) {
		super(documentId, documentClass, documentName, createdDateTime, place
				, createdPerson, approvedPerson, content);
		this.invoiceId = invoiceId;
		this.orderId = orderId;
		this.transferedPerson = transferedPerson;
		this.receivedPerson = receivedPerson;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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

}
