package org.demo.monolithic_shop_app.web_service_module.workshop;

import java.util.HashMap;

import org.demo.monolithic_shop_app.business_module.document.InvoiceDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class InvoiceApi {
	
	@GetMapping("/api/invoices")
	public String queryAllInvoices(@RequestParam(name = "page", required = false) int page, @RequestParam(name = "size", required = false) int size
									, @RequestParam(name = "sort", required = false) String sort, @RequestParam(name = "direction", required = false) String direction) {
		return "empty";
	}
	
	@PostMapping("/api/invoices")
	public String createInvoice(@Valid @RequestBody InvoiceDto invoice) {
		return "empty";
	}
	
	@GetMapping("/api/invoices/conditions")
	public String queryInvoiceByConditions(@RequestBody HashMap<String, String> conditionMap ) {
		return "empty";
	}
	
	@PatchMapping("/api/invoices/{invoice-id}")
	public String updateParticallyInvoice(@PathVariable(name = "invoice-id") String invoiceId, @RequestBody HashMap<String, String> invoice ) {
		return "empty";
	}
	
	@PutMapping("/api/invoices")
	public String updateInvoice(@Valid @RequestBody InvoiceDto invoice) {
		return "empty";
	}
	
	@DeleteMapping("/api/invoices/{invoice-id}")
	public String deleteInvoice(@PathVariable(name = "invoice-id") String invoiceId) {
		return "empty";
	}

}
