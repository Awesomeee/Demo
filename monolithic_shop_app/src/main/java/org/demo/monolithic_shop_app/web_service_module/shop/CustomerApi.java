package org.demo.monolithic_shop_app.web_service_module.shop;

import java.util.HashMap;

import org.demo.monolithic_shop_app.business_module.BusinessService;
import org.demo.monolithic_shop_app.business_module.shop.Customer;
import org.demo.monolithic_shop_app.business_module.shop.CustomerDto;
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
public class CustomerApi {
	
	@Autowired
	private BusinessService businessService;
	
	@GetMapping("/api/customers")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public CustomerDto queryAllCustomers(@RequestParam(name = "page", required = false) int page, @RequestParam(name = "size", required = false) int size
									,@RequestParam(name = "sort", required = false) String sort, @RequestParam(name = "direction", required = false) String direction) {
		return businessService.queryAllCustomers(page, size, sort, direction);
	}
	
	@PostMapping("/api/customers")
	public String addCustomer(@RequestBody(required = true) Customer customer) {
		return businessService.createNewCustomerResource(customer) + "";
	}
	
	@GetMapping("/api/customers/{customer-category}")
	public String getCustomer(@PathVariable(name = "customer-category", required = true) String customerCategory) {
		return "empty";
	}
	
	@PatchMapping("/api/customers/{customer-id}")
	public String updateParticallyCustomer(@PathVariable(name = "customer-id", required = true) String customerId, @RequestBody(required = true) HashMap<String, String> updateData) {
		return businessService.updatePartialCustomer(customerId, updateData) + "";
	}
	
	@PutMapping("/api/customers/{customer-id}")
	public String updateCustomer(@PathVariable(name = "customer-id", required = true) String customerId, @RequestBody(required = true) Customer customer) {
		return businessService.updateCustomer(customerId, customer) + "";
	}
	
	@DeleteMapping("/api/customer/{customer-id}")
	public String deleteCustomer(@PathVariable(name = "customer-id", required = true) String customerId) {
		return businessService.deleteCustomerById(customerId) + "";
	}

}
