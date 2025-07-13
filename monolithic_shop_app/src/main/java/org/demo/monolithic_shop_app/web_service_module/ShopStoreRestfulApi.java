package org.demo.monolithic_shop_app.web_service_module;

import org.demo.monolithic_shop_app.business_module.BusinessService;
import org.demo.monolithic_shop_app.business_module.ProductList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public ProductList queryProductResources(@RequestParam(name = "page", required = false) String page,@RequestParam(name = "size", required = false) String size,@RequestParam(name = "sort", required = false) String sort,@RequestParam(name = "direction", required = false) String direction) {
		return businessService.getProducts();
	}

}
