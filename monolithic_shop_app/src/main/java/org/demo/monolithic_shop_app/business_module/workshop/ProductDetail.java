package org.demo.monolithic_shop_app.business_module.workshop;

import java.util.List;

/*
 * 2025, Sat 8 Nov
 * author: duyl
 * This class intend to demonstrate clothes domain, do it will has some properties like Color, Size, Brand...
 * Other kind of product may consider creating alternative Product_X_Y_Z_Detail Class
 */
public class ProductDetail {

	private String productId;
	private String colorCode;
	private String colorName;
	private String sizeCode;
	private String sizeName;
	private String descriptionDetail;
	private String brandCode;
	private String brandName;
	private List<String> imageUrlList;
	
	public ProductDetail() {}
	
	public ProductDetail(String productId, String colorCode, String colorName, String sizeCode, String sizeName
						, String descriptionDetail, String brandCode, String brandName, List<String> imageUrlList)
	{
		this.productId = productId;
		this.colorCode = colorCode;
		this.colorName = colorName;
		this.sizeCode = sizeCode;
		this.sizeName = sizeName;
		this.descriptionDetail = descriptionDetail;
		this.brandCode = brandCode;
		this.brandName = brandName;
		this.imageUrlList = imageUrlList;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
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
	public List<String> getImageUrlList() {
		return imageUrlList;
	}
	public void setImageUrlList(List<String> imageUrlList) {
		this.imageUrlList = imageUrlList;
	}
}
