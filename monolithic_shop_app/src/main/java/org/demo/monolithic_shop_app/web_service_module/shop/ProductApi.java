package org.demo.monolithic_shop_app.web_service_module.shop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.demo.monolithic_shop_app.business_module.BusinessService;
import org.demo.monolithic_shop_app.business_module.workshop.Product;
import org.demo.monolithic_shop_app.business_module.workshop.ProductDto;
import org.demo.monolithic_shop_app.data_module.database.ProductTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ProductApi {
	
	@Autowired
	private BusinessService businessService;
	
	@Value(value = "${myapp.upload-directory}")
	private String uploadDirectory;
	
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
	public ProductDto queryProductList(@RequestParam(name = "page", required = false) int page,@RequestParam(name = "size", required = false) int size,@RequestParam(name = "sort", required = false) String sort,@RequestParam(name = "direction", required = false) String direction) {
		/*try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return businessService.queryAllProducts(page, size, sort, direction);
	}
	
	@PostMapping(path = "/api/v1/products")
	public String submitProducts(@RequestBody(required = true) Product submitData) {
		int result = businessService.createNewProductResource(submitData);
		return result + "";
	}
	
	@PostMapping(path = "/api/v2/products", consumes =  MediaType.MULTIPART_FORM_DATA_VALUE)
	public String submitProductsV2(@RequestPart(name = "productImg") MultipartFile file
								,@RequestPart(name="productFormData") Product data) {
		
		String result = "";
		//process image data
		if(file != null && !file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			String fileExtension = "";
			if(fileName != null && fileName.contains(".")) {
				fileExtension = fileName.substring(fileName.lastIndexOf("."));
			}
			String fileWriteName = file.getName() + "_" + UUID.randomUUID().toString() + fileExtension;
			Path path = Paths.get(uploadDirectory + "/" + fileWriteName);
			result = uploadDirectory + "/" + fileWriteName;
			System.out.println(result);
			try {
				Files.copy(file.getInputStream(), path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	@GetMapping(path = "/api/products/conditions")
	@ResponseStatus(code = HttpStatus.OK)
	public List<ProductTable> queryProductListByConditions(@RequestBody(required = true) HashMap<String, String> conditionMap) {
		return businessService.queryProductByDynamicallyConditions(conditionMap);
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
	
	//note to remember: need to implement 2 more api: update in batch, analyze the resource(how many resource that exist? how many categories and sub categories of it?)
	@PostMapping(path = "/api/list/products")
	public String addAListOfProductResources(@RequestBody(required = true) List<Product> submitData) {
		int result = businessService.createNewProductResource(submitData);
		return result + "";
	}
	
	public String updateAListOfProductResources() {
		return "ok";
	}
	
	@DeleteMapping(path = "/api/list/{product-ids}/products")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public String deleteAListOfProductResources(@PathVariable(name = "product-ids", required = true) List<String> productIds) {
		int result = businessService.deleteProductById(productIds);
		return result + "";
	}
	
	public String analizeProductResources() {
		return "ok";
	}
	
	@PostMapping(path = "/test")
	public String test(@RequestBody HashMap<String, String> inputData) {
		
		String result = "";
		for(String data: inputData.keySet()) {
			result = result + data + ":" + inputData.get(data)+"; ";
			
		}
		
		return result;
		
	}
	
	@PostMapping(path = "/test2")
	public List<ProductTable> test2(@RequestBody HashMap<String, String> inputData) {
		
		
		return businessService.queryProductByDynamicallyConditions(inputData);
		
	}
	

}
