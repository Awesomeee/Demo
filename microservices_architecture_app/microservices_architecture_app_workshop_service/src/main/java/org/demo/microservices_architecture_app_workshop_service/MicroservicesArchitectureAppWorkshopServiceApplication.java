package org.demo.microservices_architecture_app_workshop_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MicroservicesArchitectureAppWorkshopServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesArchitectureAppWorkshopServiceApplication.class, args);
	}

}
