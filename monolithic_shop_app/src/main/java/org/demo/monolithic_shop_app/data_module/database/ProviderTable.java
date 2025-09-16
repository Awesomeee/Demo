package org.demo.monolithic_shop_app.data_module.database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Providers")
public class ProviderTable {
	
	@Id
	private String providerId;
	@Column
	private String providerName;
	@Column
	private String phoneNumber;
	@Column
	private String address;
	@Column
	private String email;
	@Column
	private String representativeName;
	
	public ProviderTable() {}
	
	public ProviderTable(String providerId, String providerName, String phoneNumber, String address, String email
			, String representativeName) {
		this.providerId = providerId;
		this.providerName = providerName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.representativeName = representativeName;
	}
	
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	public String getRepresentativeName() {
		return representativeName;
	}
	public void setRepresentativeName(String representativeName) {
		this.representativeName = representativeName;
	}

}
