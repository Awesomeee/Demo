package org.demo.microservices_architecture_app_shop_server_loadbalancer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class MicroservicesArchitectureAppShopServiceLoadbalancerApplication {
	
	private final WebClient.Builder loadBalancedWebClientBuider;
	
	public MicroservicesArchitectureAppShopServiceLoadbalancerApplication(WebClient.Builder webClientBulder) {
		this.loadBalancedWebClientBuider = webClientBulder;
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesArchitectureAppShopServiceLoadbalancerApplication.class, args);
	}
	
	@RequestMapping("/execute")
	public Mono<String> execute() {
		return loadBalancedWebClientBuider.build().get().uri("http://shop-balancer/api/aaa")
											.retrieve().bodyToMono(String.class)
											.map(greeting -> String.format("%s, %s!" , greeting, greeting));
	}

}
