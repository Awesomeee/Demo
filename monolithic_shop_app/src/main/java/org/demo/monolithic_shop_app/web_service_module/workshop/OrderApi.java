package org.demo.monolithic_shop_app.web_service_module.workshop;

import org.demo.monolithic_shop_app.business_module.BusinessService;
import org.demo.monolithic_shop_app.business_module.workshop.OrderDto;
import org.demo.monolithic_shop_app.web_service_module.InputData.OrderInput;
import org.demo.monolithic_shop_app.web_service_module.InputData.PurchaseOrderInput;
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
public class OrderApi {
	
	@Autowired
	private BusinessService businessService;
	
	@GetMapping("/api/orders")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public OrderDto queryAllOrders(@RequestParam(name = "page", required = false) int page, @RequestParam(name = "size", required = false) int size
								,@RequestParam(name = "sort", required = false) String sort, @RequestParam(name = "direction", required = false) String direction) {
		return businessService.queryAllOrders(page, size, sort, direction);
	}
	
	/*
	 * author: duyl
	 * created date: 2025, Fri 12 Dec
	 * default: sale orders, in the future you can add a parameter which will determine whether order type
	 * is sale order or purchase order.
	 */
	@PostMapping("/api/orders")
	public String createOrder(@RequestBody(required = true) OrderInput orderInput) {
		int result = businessService.createNewSaleOrderResource(orderInput.getOrder(), orderInput.getCustomer(), orderInput.getSaleItems());
		return result + "";
	}
	
	@PostMapping("/api/orders/sale")
	public String createSaleOrder(@RequestBody(required = true) OrderInput orderInput) {
		int result = businessService.createNewSaleOrderResource(orderInput.getOrder(), orderInput.getCustomer(), orderInput.getSaleItems());
		return result + "";
	}
	
	@PostMapping("/api/orders/purchase")
	public String createPurchaseOrder(@RequestBody(required = true) PurchaseOrderInput orderInput) {
		int result = businessService.createNewPurchaseOrderResource(orderInput.getOrder(), orderInput.getProvider(), orderInput.getPurchaseItems());
		return result + "";
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
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public String deleteOrder(@PathVariable(name = "order-id", required = true) String orderId) {
		int result = businessService.deleteOrderById(orderId);
		return result + "";
	}
	
	@GetMapping("/api/orders/reports/current-day")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public OrderDto reportOrdersInCurrentDay() {
		return businessService.reportOrdersInCurrentDay();
	}
	
	@GetMapping("/api/orders/reports/current-month")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public OrderDto reportOrdersInCurrentMonth() {
		return businessService.reportOrdersInCurrentMonth();
	}

}
