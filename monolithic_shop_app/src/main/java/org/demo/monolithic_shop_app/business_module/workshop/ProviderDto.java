package org.demo.monolithic_shop_app.business_module.workshop;

import java.util.List;

public class ProviderDto {
	
	private List<Provider> providers;
	
	public ProviderDto() {}
	
	public ProviderDto(List<Provider> providers) {
		this.providers = providers;
	}
	
	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}

}
