package org.demo.monolithic_shop_app.web_service_module.InputData;

import java.util.List;

import org.demo.monolithic_shop_app.business_module.shop.Customer;
import org.demo.monolithic_shop_app.data_module.database.OrderSaleItemTable;
import org.demo.monolithic_shop_app.data_module.database.OrderTable;

public class OrderInput {
	
	private OrderTable order;
	private Customer customer;
	private List<OrderSaleItemTable> saleItems;
	
	public OrderInput() {}
	
	public OrderInput(OrderTable order, Customer customer, List<OrderSaleItemTable> saleItems) {
		this.order = order;
		this.customer = customer;
		this.saleItems = saleItems;
	}

	public OrderTable getOrder() {
		return order;
	}
	public void setOrder(OrderTable order) {
		this.order = order;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<OrderSaleItemTable> getSaleItems() {
		return saleItems;
	}
	public void setSaleItems(List<OrderSaleItemTable> saleItems) {
		this.saleItems = saleItems;
	}

}
