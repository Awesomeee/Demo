package org.demo.monolithic_shop_app.web_service_module.InputData;


import java.util.List;

import org.demo.monolithic_shop_app.business_module.workshop.Provider;
import org.demo.monolithic_shop_app.data_module.database.OrderPurchaseItemTable;
import org.demo.monolithic_shop_app.data_module.database.OrderTable;

public class PurchaseOrderInput extends OrderInput {
	
	private Provider provider;
	private List<OrderPurchaseItemTable> purchaseItems;
	
	public PurchaseOrderInput() {}
	
	public PurchaseOrderInput(OrderTable order, Provider provider, List<OrderPurchaseItemTable> purchaseItems) {
		super(order, null, null);
		this.provider = provider;
		this.purchaseItems = purchaseItems;
	}
	
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	public List<OrderPurchaseItemTable> getPurchaseItems() {
		return purchaseItems;
	}
	public void setPurchaseItems(List<OrderPurchaseItemTable> purchaseItems) {
		this.purchaseItems = purchaseItems;
	}

}
