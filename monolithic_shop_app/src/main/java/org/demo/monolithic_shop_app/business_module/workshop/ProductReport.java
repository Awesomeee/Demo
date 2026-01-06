package org.demo.monolithic_shop_app.business_module.workshop;

import java.util.List;

public class ProductReport {
	
	private int totalProductCount;
	private List<String> productCategoryNameList;
	private List<Integer> totalProductCategoryCountList;
	
	public ProductReport() {}
	
	public ProductReport(int totalProductCount, List<String> productCategoryNameList, List<Integer> totalProductCategoryCountList) {
		this.totalProductCount = totalProductCount;
		this.productCategoryNameList = productCategoryNameList;
		this.setTotalProductCategoryCountList(totalProductCategoryCountList);
	}
	
	public int getTotalProductCount() {
		return totalProductCount;
	}
	public void setTotalProductCount(int totalProductCount) {
		this.totalProductCount = totalProductCount;
	}
	public List<String> getProductCategoryNameList() {
		return productCategoryNameList;
	}
	public void setProductCategoryNameList(List<String> productCategoryNameList) {
		this.productCategoryNameList = productCategoryNameList;
	}
	public List<Integer> getTotalProductCategoryCountList() {
		return totalProductCategoryCountList;
	}
	public void setTotalProductCategoryCountList(List<Integer> totalProductCategoryCountList) {
		this.totalProductCategoryCountList = totalProductCategoryCountList;
	}

}
