package org.demo.monolithic_shop_app.business_module.product;

import java.util.ArrayList;
import java.util.List;

/*
 * author: duyl
 * created date: Wed 17 Sep, 2025
 * Dto: Data transfer object
 */
public class ProductDto {
	
	private List<Product> products;
	
	public ProductDto() {
		products = new ArrayList<Product>();
		products.add(new Product("p1", "product 1", "description 1", 10000, "VND", "provider 1"));
		products.add(new Product("p2", "product 2", "description 2", 20000, "VND", "provider 2"));
		products.add(new Product("p3", "product 3", "description 3", 30000, "VND", "provider 3"));
		products.add(new Product("p4", "product 4", "description 4", 40000, "VND", "provider 4"));
		products.add(new Product("p5", "product 5", "description 5", 50000, "VND", "provider 5"));
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
