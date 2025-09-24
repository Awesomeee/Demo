package org.demo.monolithic_shop_app.business_module.shop;

import java.time.LocalDateTime;

public class Survey {
	
	private String surveyId;
	private String surveyName;
	private String customerId;
	private String createdBy;		//employee Id
	private LocalDateTime createdDate;
	private String subject;
	private SurveyDetail surveyDetail;
	
	public Survey() {}
	
	public Survey(String surveyId, String surveyName, String customerId, String createdBy, LocalDateTime createdDate
					, String subject, SurveyDetail surveyDetail) {
		this.surveyId = surveyId;
		this.surveyName = surveyName;
		this.customerId = customerId;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.subject = subject;
		this.surveyDetail = surveyDetail;
	}
	
	public String getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}
	public String getSurveyName() {
		return surveyName;
	}
	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public SurveyDetail getSurveyDetail() {
		return surveyDetail;
	}
	public void setSurveyDetail(SurveyDetail surveyDetail) {
		this.surveyDetail = surveyDetail;
	}

}
