package org.demo.monolithic_shop_app.data_module.database;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProductDetails")
public class ProductDetailTable {
	
	@Id
	private String id;
	@OneToOne
	@JoinColumn(name = "productId")
	private ProductTable product;
	@Column
	private String colorCode;
	@Column
	private String colorName;
	@Column
	private String sizeCode;
	@Column
	private String sizeName;
	@Column
	private String descriptionDetail;
	@Column
	private String brandCode;
	@Column
	private String brandName;
	
	public ProductDetailTable() {}
	
	public ProductDetailTable(ProductTable product, String colorCode, String colorName, String sizeCode, String sizeName
						, String descriptionDetail, String brandCode, String brandName)
	{
		this.product = product;
		this.colorCode = colorCode;
		this.colorName = colorName;
		this.sizeCode = sizeCode;
		this.sizeName = sizeName;
		this.descriptionDetail = descriptionDetail;
		this.brandCode = brandCode;
		this.brandName = brandName;
	}
	
	public ProductTable getProduct() {
		return product;
	}
	public void setProduct(ProductTable product) {
		this.product = product;
	}
	public String getColorCode() {
		return colorCode;
	}
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getSizeCode() {
		return sizeCode;
	}
	public void setSizeCode(String sizeCode) {
		this.sizeCode = sizeCode;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	public String getDescriptionDetail() {
		return descriptionDetail;
	}
	public void setDescriptionDetail(String descriptionDetail) {
		this.descriptionDetail = descriptionDetail;
	}
	public String getBrandCode() {
		return brandCode;
	}
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
