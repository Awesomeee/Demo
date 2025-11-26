package org.demo.monolithic_shop_app.business_module.workshop;

import java.util.List;

public class OrderDto {
	
	private List<Order> orders;
	
	public OrderDto() {}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
