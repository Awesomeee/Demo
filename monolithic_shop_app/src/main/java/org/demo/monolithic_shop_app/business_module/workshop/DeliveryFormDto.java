package org.demo.monolithic_shop_app.business_module.workshop;

import java.util.List;

public class DeliveryFormDto {
	
	private List<DeliveryForm> deliveryFormList;
	
	public DeliveryFormDto() {}
	
	public DeliveryFormDto(List<DeliveryForm> deliveryFormList) {
		this.deliveryFormList = deliveryFormList;
	}

	public List<DeliveryForm> getDeliveryFormList() {
		return deliveryFormList;
	}

	public void setDeliveryFormList(List<DeliveryForm> deliveryFormList) {
		this.deliveryFormList = deliveryFormList;
	}

}
