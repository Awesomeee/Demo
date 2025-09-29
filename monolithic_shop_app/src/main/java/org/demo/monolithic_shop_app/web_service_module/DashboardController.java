package org.demo.monolithic_shop_app.web_service_module;

import org.demo.monolithic_shop_app.security_module.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {
	
	@Autowired
	private ApplicationProperties applicationProperties;
	
	@GetMapping("/api/dashboard/getservicemode")
	public String getServiceMode() {
		return applicationProperties.getServiceMode();
	}
	
	@GetMapping("/api/dashboard/setserviceintonovalidate")
	public String setServiceIntoNoValidate() {
		applicationProperties.setServiceMode("No_validate");
		return applicationProperties.getServiceMode();
	}
	
	@GetMapping("/api/dashboard/setserviceintovalidate")
	public String setServiceIntoValidate() {
		applicationProperties.setServiceMode("validate");
		return applicationProperties.getServiceMode();
	}

}
