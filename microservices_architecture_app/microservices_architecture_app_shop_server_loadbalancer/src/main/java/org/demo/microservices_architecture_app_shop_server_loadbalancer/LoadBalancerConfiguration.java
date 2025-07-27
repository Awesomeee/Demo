package org.demo.microservices_architecture_app_shop_server_loadbalancer;

import java.util.Arrays;
import java.util.List;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import reactor.core.publisher.Flux;

public class LoadBalancerConfiguration {

	@Bean
	@Primary
	ServiceInstanceListSupplier serviceInstanceListSupplier() {
		return new DemoServiceInstanceListSupplier("my-demo-service-instance");
	}
}

class DemoServiceInstanceListSupplier implements ServiceInstanceListSupplier {
	
	private final String serviceId;
	
	public DemoServiceInstanceListSupplier(String serviceId) {
		this.serviceId = serviceId;
	}

	@Override
	public Flux<List<ServiceInstance>> get() {
		// TODO Auto-generated method stub
		return Flux.just(Arrays.asList(new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 8080, false), 
				new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 8081, false), 
				new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 8082, false)));
	}

	@Override
	public String getServiceId() {
		// TODO Auto-generated method stub
		return serviceId;
	}
	
}