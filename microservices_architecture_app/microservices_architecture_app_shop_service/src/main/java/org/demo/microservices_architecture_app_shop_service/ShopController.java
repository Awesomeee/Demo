package org.demo.microservices_architecture_app_shop_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {
	
	@GetMapping("/api/aaa")
	public String aaa() {
		return "aaa";
	}
	
	@GetMapping("/api/aab")
	public String aab() {
		return "aab";
	}
	
	@GetMapping("/api/aac")
	public String aac() {
		return "aac";
	}
	
	@GetMapping("/api/aad")
	public String aad() {
		return "aad";
	}

}
