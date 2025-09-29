package org.demo.monolithic_shop_app.security_module;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {
	
	@Value("${myservice.mode}")
	private String serviceMode;
	
	public ApplicationProperties() {}

	public String getServiceMode() {
		return serviceMode;
	}

	public void setServiceMode(String serviceMode) {
		this.serviceMode = serviceMode;
	}

}
