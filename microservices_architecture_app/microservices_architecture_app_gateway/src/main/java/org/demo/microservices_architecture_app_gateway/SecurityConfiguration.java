package org.demo.microservices_architecture_app_gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration {

	/*
	 * author: duyl
	 * created date: Wed 16 Jul, 2025
	 * 
	 * SIMPLE: turn off csrf in formLogin mode, COMPLEX: turn on csrf in httpBasic mode, COMPLEX_2: turn on csrf in formLogin mode
	 * When use in formLogin, should turn off csrf because currently I still haven't known how to unlock it for rest client yet,
	 * the only way so far is to set security configuration so that csrf will ignore the specific endpoint you want to call,
	 * When use in httpBasic(In a microservice architecture where the service doesn't need to have form or user interaction), you
	 * can turn on csrf and follow this process: first call a GET request to endpoint /csrf-token to get csrf-token value, then you
	 * use the value of it to add a http header "X-CSRF-TOKEN" with the token value (of course we also need a Authorization httpHeader)
	 */
	@Bean
    public SecurityWebFilterChain filterChain(ServerHttpSecurity http, JwtAuthenticationFilter jwtFilter) throws Exception {
		String authenticationModel = "stateless";	//stateful, stateless
		if(authenticationModel.equals("stateful")) {
			http
	        .authorizeExchange((authorize) -> authorize
	            .anyExchange().authenticated()
	        )
	        .formLogin(Customizer.withDefaults());
		} else if(authenticationModel.equals("stateless")) {
			http
            .csrf(csrf -> csrf.disable())
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable())
            .authorizeExchange(exchanges -> exchanges
                .pathMatchers("/auth/**").permitAll()
                .anyExchange().authenticated()
            );
            // Add the JWT filter
            http.addFilterAt(jwtFilter, SecurityWebFiltersOrder.AUTHENTICATION);
		}
        return http.build();
    }
	
	@Bean
	MapReactiveUserDetailsService userDetailsService() {
		User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
		UserDetails rob = userBuilder.username("rob")
			.password("rob")
			.roles("USER")
			.build();
		UserDetails admin = userBuilder.username("admin")
			.password("admin")
			.roles("USER","ADMIN")
			.build();
		return new MapReactiveUserDetailsService(rob, admin);
	}
    
}
