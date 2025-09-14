package org.demo.monolithic_shop_app.data_module;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Products")
public class ProductTable {

	@Id
	private String id;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private long price;
	
	@Column
	private String currency;
	
	@Column
	private String provider;
	
	public ProductTable() {}
	
	public ProductTable(String id, String name, String description, long price, String currency, String provider) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.currency = currency;
		this.provider = provider;
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
}
