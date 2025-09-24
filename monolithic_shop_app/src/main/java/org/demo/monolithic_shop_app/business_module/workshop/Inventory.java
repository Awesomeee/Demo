package org.demo.monolithic_shop_app.business_module.workshop;

import java.util.List;

public class Inventory {
	
	private String inventoryId;
	private String inventoryName;
	private List<Shelf> shelfList;
	
	public Inventory() {}
	
	public Inventory(String inventoryId, String inventoryName, List<Shelf> shelfList) {
		this.inventoryId = inventoryId;
		this.inventoryName = inventoryName;
		this.shelfList = shelfList;
	}
	
	public String getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}
	public String getInventoryName() {
		return inventoryName;
	}
	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}
	public List<Shelf> getShelfList() {
		return shelfList;
	}
	public void setShelfList(List<Shelf> shelfList) {
		this.shelfList = shelfList;
	}

}
