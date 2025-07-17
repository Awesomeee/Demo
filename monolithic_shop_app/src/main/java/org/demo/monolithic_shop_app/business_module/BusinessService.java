package org.demo.monolithic_shop_app.business_module;

import java.util.ArrayList;
import java.util.List;

import org.demo.monolithic_shop_app.data_module.ProductTable;
import org.demo.monolithic_shop_app.data_module.ProductTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service(value = "BusinessBean")
public class BusinessService {
	
	@Autowired
	private ProductTableRepository productTableRepository;

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
	
	public ProductList queryAllProducts(int pageNumber, int pageSize, String sortType, String direction) {
		Sort sort = Sort.by(sortType);
		if(direction.equals("asc")) {
			sort = sort.ascending();
		} else if(direction.equals("desc")) {
			sort = sort.descending();
		}
		List<ProductTable> rows = productTableRepository.findAll(PageRequest.of(pageNumber, pageSize, sort)).getContent();
		List<Product> products = new ArrayList<Product>();
		for(int i=0; i<rows.size();i++) {
			Product element = new Product();
			element.setId(rows.get(i).getId());
			element.setName(rows.get(i).getName());
			element.setDescription(rows.get(i).getDescription());
			element.setPrice(rows.get(i).getPrice());
			element.setCurrency(rows.get(i).getCurrency());
			element.setProvider(rows.get(i).getProvider());
			
			products.add(element);
		}
		ProductList result = new ProductList();
		result.setProducts(products);
		return result;
	}
	
	public int deleteProductById(String id) {
		return 1;
	}
	
	public void updateProductByName(String name, String property, String value) {
		//default value for testing
		name = "product 5";
	}
}
