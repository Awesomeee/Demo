package org.demo.monolithic_shop_app.business_module.workshop;

import java.time.LocalDateTime;

/*
 * author: duyl
 * created date: Wed 24 Sep, 2025
 * Description: Class Report là 1 class chứa mô tả về thông tin của các loại biên bản, báo cáo (
 * biên bản nhập kho, biên bản xuất kho, biên bản nhận hàng, biên bản giao hàng...)
 */
public class Report {

	private String reportId;
	private String reportName;
	private String reportClassId;
	private String reportClassName;
	private LocalDateTime createdDateTime;
	private String createdPerson;		//employee id
	private String approvedPerson;		//employee id
	private String location;
	private String description;
	
	public Report() {}
	
	public Report(String reportId, String reportName, String reportClassId, String reportClassName, LocalDateTime createdDateTime
			,String createdPerson, String approvedPerson, String location, String description) {
		this.reportId = reportId;
		this.reportName = reportName;
		this.reportClassId = reportClassId;
		this.reportClassName = reportClassName;
		this.createdDateTime = createdDateTime;
		this.createdPerson = createdPerson;
		this.approvedPerson = approvedPerson;
		this.location = location;
		this.description = description;
	}
	
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getReportClassId() {
		return reportClassId;
	}
	public void setReportClassId(String reportClassId) {
		this.reportClassId = reportClassId;
	}
	public String getReportClassName() {
		return reportClassName;
	}
	public void setReportClassName(String reportClassName) {
		this.reportClassName = reportClassName;
	}
	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
