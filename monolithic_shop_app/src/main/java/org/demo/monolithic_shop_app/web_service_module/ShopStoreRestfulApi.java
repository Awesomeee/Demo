package org.demo.monolithic_shop_app.web_service_module;

import java.util.HashMap;

import org.demo.monolithic_shop_app.business_module.BusinessService;
import org.demo.monolithic_shop_app.business_module.Product;
import org.demo.monolithic_shop_app.business_module.ProductList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopStoreRestfulApi {
	
	@Autowired
	private BusinessService businessService;
	
	@GetMapping(path = "/guest")
	public String welcome() {
		return "welcome to our store";
	}
	
	/*
	 * author: duyl
	 * create_date: Sun 13 Jul, 2025
	 * 
	 * example endpoint
	 * filtering:	localhost:port/api/products?productId=123&productType=wood
	 * paging:		localhost:port/api/products?page=3&size=2
	 * sorting:		localhost:port/api/products?sort=productType&direction=asc
	 */
	@GetMapping(path = "/api/products")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public ProductList queryProductList(@RequestParam(name = "page", required = false) int page,@RequestParam(name = "size", required = false) int size,@RequestParam(name = "sort", required = false) String sort,@RequestParam(name = "direction", required = false) String direction) {
		return businessService.queryAllProducts(page, size, sort, direction);
	}
	
	@PostMapping(path = "/api/products")
	public String submitProducts(@RequestBody(required = true) Product submitData) {
		int result = businessService.createNewProductResource(submitData);
		return result + "";
	}
	
	@GetMapping(path = "/api/products/{product-category}")
	@ResponseStatus(code = HttpStatus.OK)
	public String queryProductListByCategory() {
		return "result";
	}
	
	@GetMapping(path = "/api/products/{product-id}")
	@ResponseStatus(code = HttpStatus.OK)
	public String queryProductDetail() {
		return "result";
	}
	
	@PatchMapping(path = "/api/products/{product-id}")
	@ResponseStatus(code = HttpStatus.OK)
	public String updatePartiallyProductResource(@PathVariable(name = "product-id", required = true) String productId, @RequestBody(required = true) HashMap<String, String> updateData) {
		int result = businessService.updatePartialProduct(productId, updateData);
		return result + "";
	}
	
	@PutMapping(path = "/api/products/{product-id}")
	@ResponseStatus(code = HttpStatus.OK)
	public String updateProductResource(@PathVariable(name = "product-id", required = true) String productId, @RequestBody(required = true) Product updateData) {
		int result = businessService.updateProduct(productId, updateData);
		return result + "";
	}
	
	@DeleteMapping(path = "/api/products/{product-id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public String deleteProductResource(@PathVariable(name = "product-id", required = true) String productId) {
		int result = businessService.deleteProductById(productId);
		return result + "";
	}
	
	@PostMapping(path = "/test")
	public String test(@RequestBody HashMap<String, String> inputData) {
		
		String result = "";
		for(String data: inputData.keySet()) {
			result = result + data + ":" + inputData.get(data)+"; ";
			
		}
		
		return result;
		
	}

}
