package org.demo.monolithic_shop_app.business_module.sale_and_marketing;

import org.demo.monolithic_shop_app.security_module.User;

public class Customer {
	
	private String customerId;
	private String customerName;
	private String phoneNumber;
	private String email;
	private String address;
	private String identityNumber;		// căn cước công dân
	private User user;
	
	public Customer() {}
	
	public Customer(String customerId, String customerName, String phoneNumber, String email, String address
			, String identityNumber, User user) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.identityNumber = identityNumber;
		this.user = user;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIdentityNumber() {
		return identityNumber;
	}
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
