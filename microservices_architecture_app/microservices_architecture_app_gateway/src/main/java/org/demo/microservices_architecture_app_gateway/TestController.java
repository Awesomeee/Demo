package org.demo.microservices_architecture_app_gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping(path = "/hello")
	public String helloGateway() {
		return "Greeting from gateway";
	}

}
