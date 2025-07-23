package org.demo.microservices_architecture_app_workshop_service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkshopController {
	
	@GetMapping("/test")
	@Cacheable("tests")
	public String test() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "test";
	}
	
	@GetMapping("/ccc")
	public String ccc() {
		return "ccc";
	}

}
