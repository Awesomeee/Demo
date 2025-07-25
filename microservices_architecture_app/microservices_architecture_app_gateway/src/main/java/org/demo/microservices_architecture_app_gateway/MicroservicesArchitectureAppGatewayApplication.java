package org.demo.microservices_architecture_app_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class MicroservicesArchitectureAppGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesArchitectureAppGatewayApplication.class, args);
	}
	
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
	    return builder.routes()
    		.route(p -> p
    	            .path("/api/**")
    	            .filters(f -> f.addRequestHeader("Hello", "World")
    	            				)
    	            .uri("http://localhost:8080"))
    		.route(p -> p
		            .path("/**")
		            .and()
		            .not(np -> np.path("/api/**"))
		            .filters(f -> f.addRequestHeader("Hello", "World")
		            		)
		            .uri("http://127.0.0.1:4200"))
	        .build();
	}
	
	@RequestMapping("/fallback")
	public Mono<String> fallback() {
	  return Mono.just("fallback");
	}

}
