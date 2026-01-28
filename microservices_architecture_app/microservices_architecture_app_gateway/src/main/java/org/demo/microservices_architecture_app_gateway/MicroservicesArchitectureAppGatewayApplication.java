package org.demo.microservices_architecture_app_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

/*
 * author: duyl, date: 2026, Sun 25 Jan, Place: Ho Chi Minh city
 * after starting the server, remember to open this url first: http://localhost/actuator/circuitbreakers
 * This action will do a "manual warm-up" trick to avoid the first api call failure and trigger the circuit breaker
 */
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
    	            				.circuitBreaker(config -> config
    	            											.setName("cBreaker_1")
    	            											.setFallbackUri("forward:/backup")))
    	            .uri("http://localhost:8080"))
    		.route(p -> p
    	            .path("/execute")
    	            .filters(f -> f.addRequestHeader("Hello", "World")
    	            				)
    	            .uri("http://localhost:8000"))
    		/*.route(p -> p
		            .path("/**")
		            .and()
		            .not(np -> np.path("/api/**"))
		            .filters(f -> f.addRequestHeader("Hello", "World")
		            		)
		            .uri("http://127.0.0.1:4200"))*/
	        .build();
	}
	
	@RequestMapping("/fallback")
	public Mono<String> fallback() {
	  return Mono.just("fallback");
	}
	
	@RequestMapping("/backup")
	public Mono<String> backup() {
		return WebClient.builder().build()
			      .get().uri("http://localhost:8081/api/aac").retrieve()
			      .bodyToMono(String.class);
	}

}
