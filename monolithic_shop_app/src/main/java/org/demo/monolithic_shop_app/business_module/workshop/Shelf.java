package org.demo.monolithic_shop_app.business_module.workshop;

import java.util.List;

public class Shelf {
	
	private String shelfId;
	private String shelfName;
	private List<Product> productList;
	
	public Shelf() {}
	
	public Shelf(String shelfId, String shelfName, List<Product> productList) {
		this.shelfId = shelfId;
		this.shelfName = shelfName;
		this.productList = productList;
	}
	
	public String getShelfId() {
		return shelfId;
	}
	public void setShelfId(String shelfId) {
		this.shelfId = shelfId;
	}
	public String getShelfName() {
		return shelfName;
	}
	public void setShelfName(String shelfName) {
		this.shelfName = shelfName;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}
