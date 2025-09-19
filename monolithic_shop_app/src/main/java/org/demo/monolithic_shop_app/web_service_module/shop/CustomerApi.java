package org.demo.monolithic_shop_app.web_service_module.shop;

import org.demo.monolithic_shop_app.business_module.sale_and_marketing.CustomerDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerApi {
	
	@GetMapping("/api/customers")
	public String queryAllCustomers(@RequestParam(name = "page", required = false) int page, @RequestParam(name = "size", required = false) int size
									,@RequestParam(name = "sort", required = false) String sort, @RequestParam(name = "direction", required = false) String direction) {
		return "empty";
	}
	
	@PostMapping("/api/customers")
	public String addCustomer(@RequestBody(required = true) CustomerDto customer) {
		return "empty";
	}
	
	@GetMapping("/api/customers/{customer-category}")
	public String getCustomer(@PathVariable(name = "customer-category", required = true) String customerCategory) {
		return "empty";
	}
	
	@PatchMapping("/api/customers/{customer-id}")
	public String updateParticallyCustomer(@PathVariable(name = "customer-id", required = true) String customerId, @RequestBody(required = true) CustomerDto customer) {
		return "empty";
	}
	
	@PutMapping("/api/customers/{customer-id}")
	public String updateCustomer(@PathVariable(name = "customer-id", required = true) String customerId, @RequestBody(required = true) CustomerDto customer) {
		return "empty";
	}
	
	@DeleteMapping("/api/customer/{customer-id}")
	public String deleteCustomer(@PathVariable(name = "customer-id", required = true) String customerId) {
		return "empty";
	}

}
