package org.demo.monolithic_shop_app.web_service_module.workshop;

import org.demo.monolithic_shop_app.business_module.BusinessService;
import org.demo.monolithic_shop_app.business_module.workshop.PaymentForm;
import org.demo.monolithic_shop_app.business_module.workshop.PaymentFormDto;
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
public class PaymentFormApi {
	
	@Autowired
	private BusinessService businessService;
	
	@GetMapping("/api/payment-forms")
	public PaymentFormDto queryPaymentForms(@RequestParam(name = "page", required = false) int page, @RequestParam(name = "size", required = false) int size
			,@RequestParam(name = "sort", required = false) String sort, @RequestParam(name = "direction", required = false) String direction) {
		return businessService.queryAllPaymentForms(page, size, sort, direction);
	}
	
	@PostMapping("/api/payment-forms")
	public String submitPaymentForms(@RequestBody(required = true) PaymentForm paymentForm) {
		return businessService.createNewPaymentFormResource(paymentForm) + "";
	}
	
	@PutMapping("/api/payment-forms/{payment-form-id}")
	public String updatePaymentForm(@PathVariable("{payment-form-id}") String paymentFormId, @RequestBody(required = true) PaymentForm paymentForm) {
		return businessService.updatePaymentForm(paymentFormId, paymentForm) + "";
	}
	
	@DeleteMapping("/api/payment-forms/{payment-form-id}")
	public String deletePaymentForm(@PathVariable("{payment-form-id}") String paymentFormId) {
		return businessService.deletePaymentForm(paymentFormId) + "";
	}

}
