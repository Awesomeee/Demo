package org.demo.microservices_architecture_app_shop_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {
	
	@GetMapping("/aaa")
	public String aaa() {
		return "aaa";
	}
	
	@GetMapping("/aab")
	public String aab() {
		return "aab";
	}
	
	@GetMapping("/aac")
	public String aac() {
		return "aac";
	}
	
	@GetMapping("/aad")
	public String aad() {
		return "aad";
	}

}
