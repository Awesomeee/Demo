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

	@Bean
    public SecurityWebFilterChain filterChain(ServerHttpSecurity http, JwtAuthenticationFilter jwtFilter) throws Exception {
		String authenticationModel = "stateful";	//stateful, stateless
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
