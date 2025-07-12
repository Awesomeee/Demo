package org.demo.monolithic_shop_app.web_service_module;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopStoreRestfulApi {
	
	@GetMapping(path = "/guest")
	public String welcome() {
		return "welcome to our store";
	}

}
