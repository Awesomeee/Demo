package org.demo.monolithic_shop_app.business_module.shop;

import java.util.List;

public class CustomerDto {
	
	private List<Customer> customers;
	
	public CustomerDto() {}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

}
