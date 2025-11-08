package org.demo.monolithic_shop_app.data_module.database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ImageResources")
public class ImageResourceTable {
	
	@Id
	private String id;
	@ManyToOne
	@JoinColumn(name = "productDetailId")
	private ProductDetailTable productDetail;
	@Column
	private String uri;
	
	public ImageResourceTable() {}
	
	public ImageResourceTable(String id, ProductDetailTable productDetail, String uri) {
		this.id = id;
		this.productDetail = productDetail;
		this.uri = uri;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ProductDetailTable getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(ProductDetailTable productDetail) {
		this.productDetail = productDetail;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}

}
