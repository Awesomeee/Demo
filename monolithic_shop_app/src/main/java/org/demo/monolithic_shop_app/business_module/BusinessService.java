package org.demo.monolithic_shop_app.business_module;

import org.springframework.stereotype.Service;

@Service(value = "BusinessBean")
public class BusinessService {

	private ProductList products;
	
	public BusinessService() {
		setProducts(new ProductList());
	}

	public ProductList getProducts() {
		return products;
	}

	public void setProducts(ProductList products) {
		this.products = products;
	}
	
	public void queryProducts() {
		
	}
	
	public void updateProductByName(String name, String property, String value) {
		//default value for testing
		name = "product 5";
	}
}
