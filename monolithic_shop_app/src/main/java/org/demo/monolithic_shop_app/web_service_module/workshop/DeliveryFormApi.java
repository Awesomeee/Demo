package org.demo.monolithic_shop_app.web_service_module.workshop;

import org.demo.monolithic_shop_app.business_module.BusinessService;
import org.demo.monolithic_shop_app.business_module.workshop.DeliveryForm;
import org.demo.monolithic_shop_app.business_module.workshop.DeliveryFormDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryFormApi {
	
	@Autowired
	private BusinessService businessService;
	
	@GetMapping("/api/delivery-forms")
	public DeliveryFormDto queryDeliveryForms(@RequestParam(name = "page", required = false) int page, @RequestParam(name = "size", required = false) int size
			,@RequestParam(name = "sort", required = false) String sort, @RequestParam(name = "direction", required = false) String direction) {
		return businessService.queryAllDeliveryForms(page, size, sort, direction);
	}
	
	@PostMapping("/api/delivery-forms")
	public String submitDeliveryForms(@RequestBody(required = true) DeliveryForm deliveryForm) {
		return businessService.createNewDeliveryFormResource(deliveryForm) + "";
	}
	
	@PutMapping("/api/delivery-forms/{delivery-form-id}")
	public String updateDeliveryForm(@PathVariable("{delivery-form-id}") String deliveryFormId, @RequestBody(required = true) DeliveryForm deliveryForm) {
		return businessService.updateDeliveryForm(deliveryFormId, deliveryForm) + "";
	}
	
	@DeleteMapping("/api/delivery-forms/{delivery-form-id}")
	public String deleteDeliveryForm(@PathVariable("{delivery-form-id}") String deliveryFormId) {
		return businessService.deleteDeliveryForm(deliveryFormId) + "";
	}

}
