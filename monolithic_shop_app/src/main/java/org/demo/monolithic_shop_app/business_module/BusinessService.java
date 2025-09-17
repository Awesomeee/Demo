package org.demo.monolithic_shop_app.business_module;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.demo.monolithic_shop_app.business_module.product.Product;
import org.demo.monolithic_shop_app.business_module.product.ProductDto;
import org.demo.monolithic_shop_app.data_module.database.ProductTable;
import org.demo.monolithic_shop_app.data_module.database.ProductTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service(value = "BusinessBean")
public class BusinessService {
	
	@Autowired
	private ProductTableRepository productTableRepository;

	private ProductDto products;
	
	public BusinessService() {
		setProducts(new ProductDto());
	}

	public ProductDto getProducts() {
		return products;
	}

	public void setProducts(ProductDto products) {
		this.products = products;
	}
	
	public ProductDto queryAllProducts(int pageNumber, int pageSize, String sortType, String direction) {
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
		ProductDto result = new ProductDto();
		result.setProducts(products);
		return result;
	}
	
	public int createNewProductResource(Product product) {
		int result = 1;
		try {
			ProductTable row = new ProductTable(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getCurrency(), product.getProvider());
			productTableRepository.save(row);
		} catch (Exception e) {
			result = 0;
			System.err.println(e.getMessage());
		}
		return result;
	}
	
	public int updateProduct(String id, Product product) {
		int result = 1;
		try {
			Optional<ProductTable> updateRow = productTableRepository.findById(id);
			updateRow.get().setName(product.getName());
			updateRow.get().setDescription(product.getDescription());
			updateRow.get().setPrice(product.getPrice());
			updateRow.get().setCurrency(product.getCurrency());
			updateRow.get().setProvider(product.getProvider());
			productTableRepository.save(updateRow.get());
		} catch (Exception e) {
			result = 0;
			System.err.println(e.getMessage());
		}
		return result;
	}
	
	public int updatePartialProduct(String id, HashMap<String, String> updateDatas) {
		int result = 1;
		try {
			Optional<ProductTable> updateRow = productTableRepository.findById(id);
			Field[] fields = updateRow.get().getClass().getDeclaredFields();
			
			boolean isUpdate = false;
			for(String data: updateDatas.keySet()) {
				for(int i=0;i<fields.length;i++) {
					if(fields[i].getName().equals(data)) {
						//update object data
						updateRow.get().getClass().getMethod("set" + data.substring(0, 1).toUpperCase() + data.substring(1), String.class).invoke(updateRow.get(), updateDatas.get(data));
						isUpdate = true;
						break;
					}
				}
				
			}
			
			if(isUpdate)
				productTableRepository.save(updateRow.get());
		
		} catch(Exception e) {
			result = 0;
			System.err.println(e.getMessage());
		}
		return result;
	}
	
	public int deleteProductById(String id) {
		int result = 1;
		try {
			productTableRepository.deleteById(id);
		} catch(Exception e) {
			result = 0;
			System.err. print(e.getMessage());
		}
		return result;
	}

}
