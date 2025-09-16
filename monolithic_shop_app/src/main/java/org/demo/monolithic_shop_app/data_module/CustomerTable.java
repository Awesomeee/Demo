package org.demo.monolithic_shop_app.data_module;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customers")
public class CustomerTable {
	
	@Id
	private String customerId;
	@Column
	private String customerName;
	@Column
	private String phoneNumber;
	@Column
	private String email;
	@Column
	private String address;
	@Column
	private String identityNumber;		// căn cước công dân
	@OneToOne
	@JoinColumn(name = "userId")
	private UserTable user;
	
	public CustomerTable() {}
	
	public CustomerTable(String customerId, String customerName, String phoneNumber, String email, String address
			, String identityNumber, UserTable user) {
		this.setCustomerId(customerId);
		this.setCustomerName(customerName);
		this.setPhoneNumber(phoneNumber);
		this.setEmail(email);
		this.setAddress(address);
		this.setIdentityNumber(identityNumber);
		this.setUser(user);
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

	public UserTable getUser() {
		return user;
	}

	public void setUser(UserTable user) {
		this.user = user;
	}

}
