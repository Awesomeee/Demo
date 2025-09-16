package org.demo.monolithic_shop_app.data_module.database;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employees")
public class EmployeeTable {
	
	@Id
	private String employeeId;
	@Column
	private String employeeName;
	@Column
	private String phoneNumber;
	@Column
	private String identityNumber;		//căn cước công dân
	@Column
	private String address;
	@Column
	private String email;
	@Column
	private LocalDateTime onboardDateTime;
	@OneToOne
	@JoinColumn(name = "userId")
	private UserTable user;
	
	public EmployeeTable() {}
	
	public EmployeeTable(String employeeId, String employeeName, String phoneNumber, String identityNumber, String address, String email
			, LocalDateTime onboardDateTime, UserTable user) {
		this.setEmployeeId(employeeId);
		this.setEmployeeName(employeeName);
		this.setPhoneNumber(phoneNumber);
		this.setIdentityNumber(identityNumber);
		this.setAddress(address);
		this.setEmail(email);
		this.setOnboardDateTime(onboardDateTime);
		this.setUser(user);
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

	public UserTable getUser() {
		return user;
	}

	public void setUser(UserTable user) {
		this.user = user;
	}

}
