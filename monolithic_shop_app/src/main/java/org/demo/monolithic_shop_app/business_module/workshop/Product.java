package org.demo.monolithic_shop_app.business_module.workshop;

import jakarta.validation.constraints.Size;

public class Product {
	
	private String id;
	private String name;
	@Size(min = 0, max = 255)
	private String description;
	private long price;
	private String currency;
	private String provider;
	private ProductDetail productDetail;
	
	public Product() {}
	
	public Product(String id, String name, String description, long price, String currency, String provider
			, ProductDetail productDetail) {
		if(id != null)
			this.id = id;
		if(name != null)
			this.name = name;
		if(description != null)
			this.description = description;
		this.price = price;
		if(currency != null)
			this.currency = currency;
		if(provider != null)
			this.provider = provider;
		if(productDetail != null)
			this.productDetail = productDetail;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}

	public ProductDetail getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}

}
