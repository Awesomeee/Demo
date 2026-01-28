package org.demo.microservices_architecture_app_shop_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {
	
	@GetMapping("/api/aaa")
	public String aaa() {
		System.out.println("service aaa from shop service called");
		return "aaa";
	}
	
	@GetMapping("/api/aab")
	public String aab() {
		return "aab";
	}
	
	@GetMapping("/api/aac")
	public String aac() {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "aac";
	}
	
	@GetMapping("/api/aad")
	public String aad() {
		int number_1 = 5;
		int number_2 = 0;
		int number_3 = number_1/number_2;
		return "aad " + number_3;
	}

}
