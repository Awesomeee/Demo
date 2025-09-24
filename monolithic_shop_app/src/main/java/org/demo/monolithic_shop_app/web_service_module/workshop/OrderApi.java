package org.demo.monolithic_shop_app.web_service_module.workshop;

import org.demo.monolithic_shop_app.business_module.shop.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderApi {
	
	@GetMapping("/api/orders")
	@ResponseStatus(code = HttpStatus.OK)
	public String queryAllOrders(@RequestParam(name = "page", required = false) int page, @RequestParam(name = "size", required = false) int size
								,@RequestParam(name = "sort", required = false) String sort, @RequestParam(name = "direction", required = false) String direction) {
		return "empty";
	}
	
	@PostMapping("/api/orders")
	public String createOrder(@RequestBody(required = true) OrderDto order) {
		return "empty";
	}
	
	@GetMapping("/api/orders/{order-category}")
	public String getOrder(@PathVariable(name = "order-category", required = true) String orderCategory) {
		return "empty";
	}
	
	@PatchMapping("/api/orders/{order-id}")
	public String updateParticiallyOrder(@PathVariable(name = "order-id", required = true) String orderId, @RequestBody(required = true) OrderDto order) {
		return "empty";
	}
	
	@PutMapping("/api/orders/{order-id}")
	public String updateOrder(@PathVariable(name = "order-id", required = true) String orderId, @RequestBody(required = true) OrderDto order) {
		return "empty";
	}
	
	@DeleteMapping("/api/orders/{order-id}")
	public String deleteOrder(@PathVariable(name = "order-id", required = true) String orderId) {
		return "empty";
	}

}
