package org.demo.microservices_architecture_app_eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroservicesArchitectureAppEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesArchitectureAppEurekaServerApplication.class, args);
	}

}
