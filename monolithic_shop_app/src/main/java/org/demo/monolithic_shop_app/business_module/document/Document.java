package org.demo.monolithic_shop_app.business_module.document;

import java.time.LocalDateTime;

public class Document {
	
	private String documentId;
	private String documentClass;
	private String documentName;
	private LocalDateTime createdDateTime;
	private String place;		//địa điểm
	private String createdPerson;
	private String approvedPerson;
	private String content;
	
	public Document() {}
	
	public Document(String documentId, String documentClass, String documentName, LocalDateTime createdDateTime
			, String place, String createdPerson, String approvedPerson, String content) {
		this.documentId = documentId;
		this.documentClass = documentClass;
		this.documentName = documentName;
		this.createdDateTime = createdDateTime;
		this.place = place;
		this.createdPerson = createdPerson;
		this.approvedPerson = approvedPerson;
		this.content = content;
	}
	
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
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
