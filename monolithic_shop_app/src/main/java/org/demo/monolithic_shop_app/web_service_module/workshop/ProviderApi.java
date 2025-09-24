package org.demo.monolithic_shop_app.web_service_module.workshop;

import java.util.HashMap;

import org.demo.monolithic_shop_app.business_module.workshop.ProviderDto;
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
public class ProviderApi {
	
	@GetMapping("/api/providers")
	public String queryAllProviders(@RequestParam(name = "page", required = false) int page, @RequestParam(name = "size", required = false) int size
									, @RequestParam(name = "sort", required = false) String sort, @RequestParam(name = "direction", required = false) String direction) {
		return "empty";
	}
	
	@PostMapping("/api/providers")
	public String createProvider(@Valid @RequestBody ProviderDto provider) {
		return "empty";
	}
	
	@GetMapping("/api/providers/conditions")
	public String queryProviderByConditions(@RequestBody HashMap<String, String> conditionMap ) {
		return "empty";
	}
	
	@PatchMapping("/api/providers/{provider-id}")
	public String updateParticallyProvider(@PathVariable(name = "provider-id") String providerId, @RequestBody HashMap<String, String> provider ) {
		return "empty";
	}
	
	@PutMapping("/api/providers")
	public String updateProvider(@Valid @RequestBody ProviderDto provider) {
		return "empty";
	}
	
	@DeleteMapping("/api/providers/{provider-id}")
	public String deleteProvider(@PathVariable(name = "provider-id") String providerId) {
		return "empty";
	}

}
