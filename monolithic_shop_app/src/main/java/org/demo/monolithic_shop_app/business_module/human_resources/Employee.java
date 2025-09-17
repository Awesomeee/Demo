package org.demo.monolithic_shop_app.business_module.human_resources;

import java.time.LocalDateTime;

import org.demo.monolithic_shop_app.security_module.User;

public class Employee {
	
	private String employeeId;
	private String employeeName;
	private String phoneNumber;
	private String identityNumber;		//căn cước công dân
	private String address;
	private String email;
	private LocalDateTime onboardDateTime;
	private User user;
	
	public Employee() {}
	
	public Employee(String employeeId, String employeeName, String phoneNumber, String identityNumber, String address, String email
			, LocalDateTime onboardDateTime, User user) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.phoneNumber = phoneNumber;
		this.identityNumber = identityNumber;
		this.address = address;
		this.email = email;
		this.onboardDateTime = onboardDateTime;
		this.user = user;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getIdentityNumber() {
		return identityNumber;
	}
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDateTime getOnboardDateTime() {
		return onboardDateTime;
	}
	public void setOnboardDateTime(LocalDateTime onboardDateTime) {
		this.onboardDateTime = onboardDateTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
