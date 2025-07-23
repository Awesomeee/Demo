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
	            .path("/aaa")
	            .filters(f -> f.addRequestHeader("Hello", "World")
	            				.circuitBreaker(config -> config.setFallbackUri("forward:/fallback")))
	            .uri("http://localhost:8080/aaa"))
	        .route(p -> p
		            .path("/aab")
		            .filters(f -> f.addRequestHeader("Hello", "World"))
		            .uri("http://localhost:8080/aab"))
	        .route(p -> p
		            .path("/aac")
		            .filters(f -> f.addRequestHeader("Hello", "World"))
		            .uri("http://localhost:8080/aac"))
	        .route(p -> p
		            .path("/aad")
		            .filters(f -> f.addRequestHeader("Hello", "World"))
		            .uri("http://localhost:8080/aad"))
	        .route(p -> p
		            .path("/ccc")
		            .filters(f -> f.addRequestHeader("Hello", "World"))
		            .uri("http://localhost:8081/ccc"))
	        .build();
	}
	
	@RequestMapping("/fallback")
	public Mono<String> fallback() {
	  return Mono.just("fallback");
	}

}
