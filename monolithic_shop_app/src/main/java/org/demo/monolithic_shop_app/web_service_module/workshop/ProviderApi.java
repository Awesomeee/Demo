package org.demo.monolithic_shop_app.web_service_module.workshop;

import java.util.HashMap;

import org.demo.monolithic_shop_app.business_module.BusinessService;
import org.demo.monolithic_shop_app.business_module.workshop.Provider;
import org.demo.monolithic_shop_app.business_module.workshop.ProviderDto;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private BusinessService businessService;
	
	@GetMapping("/api/providers")
	public ProviderDto queryAllProviders(@RequestParam(name = "page", required = false) int page, @RequestParam(name = "size", required = false) int size
									, @RequestParam(name = "sort", required = false) String sort, @RequestParam(name = "direction", required = false) String direction) {
		return businessService.queryAllProviders(page, size, sort, direction);
	}
	
	@PostMapping("/api/providers")
	public String createProvider(@Valid @RequestBody Provider provider) {
		return businessService.createNewProviderResource(provider) + "";
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
	public String updateProvider(@Valid @RequestBody Provider provider) {
		return businessService.updateProvider(provider.getProviderId(), provider) + "";
	}
	
	@DeleteMapping("/api/providers/{provider-id}")
	public String deleteProvider(@PathVariable(name = "provider-id") String providerId) {
		return businessService.deleteProvider(providerId) + "";
	}

}
