package org.demo.monolithic_shop_app.business_module;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
	
	private List<Product> products;
	
	public ProductList() {
		products = new ArrayList<Product>();
		products.add(new Product("p1", "product 1", "description 1", 10000, "VND", "provider 1"));
		products.add(new Product("p2", null, "description 2", 20000, "VND", "provider 2"));
		products.add(new Product("p3", "product 3", null, 30000, "VND", "provider 3"));
		products.add(new Product("p4", "product 4", "description 4", 40000, null, "provider 4"));
		products.add(new Product("p5", "product 5", "description 5", 50000, "VND", null));
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
