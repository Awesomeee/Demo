package org.demo.monolithic_shop_app.security_module;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
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
    public SecurityFilterChain filterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
		String mode = "SIMPLE";		//SIMPLE: turn off csrf in formLogin mode, COMPLEX: turn on csrf in httpBasic mode, COMPLEX_2: turn on csrf in formLogin mode
		if(mode == "SIMPLE") {
	        http
	            // Disable CSRF for H2 console
	        	.csrf(csrf -> csrf.disable())	//disable csrf completely
	            // Allow frames from the same origin (essential for H2 console)
	            .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()))
	            // Permit all requests to H2 console path
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers(antMatcher("/h2-console/**"), antMatcher("/guest/**"), antMatcher("/css/**"), antMatcher("/js/**"), antMatcher("/api/products"), antMatcher("/test/**")).permitAll()
	                .anyRequest().authenticated() // Protect other endpoints
	            )
	            .formLogin(Customizer.withDefaults());
		} else if (mode == "COMPLEX") {
			http
	            // Disable CSRF for H2 console
	            .csrf(csrf -> csrf.ignoringRequestMatchers(antMatcher("/h2-console/**"), antMatcher("/test/**")))
	        	//.csrf(csrf -> csrf.disable())	//disable csrf completely
	            // Allow frames from the same origin (essential for H2 console)
	            .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()))
	            // Permit all requests to H2 console path
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers(antMatcher("/h2-console/**"), antMatcher("/guest/**"), antMatcher("/css/**"), antMatcher("/js/**"), antMatcher("/api/products"), antMatcher("/test/**")).permitAll()
	                .anyRequest().authenticated() // Protect other endpoints
	            )
	            //.formLogin(Customizer.withDefaults());
	            .httpBasic(Customizer.withDefaults());
		} else if (mode == "COMPLEX_2") {
			http
            // Disable CSRF for H2 console
            .csrf(csrf -> csrf.ignoringRequestMatchers(antMatcher("/h2-console/**"), antMatcher("/test/**")))
        	//.csrf(csrf -> csrf.disable())	//disable csrf completely
            // Allow frames from the same origin (essential for H2 console)
            .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()))
            // Permit all requests to H2 console path
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(antMatcher("/h2-console/**"), antMatcher("/guest/**"), antMatcher("/css/**"), antMatcher("/js/**"), antMatcher("/api/products"), antMatcher("/test/**")).permitAll()
                .anyRequest().authenticated() // Protect other endpoints
            )
            .formLogin(Customizer.withDefaults());
		}
        return http.build();
    }

    // This bean is needed for MvcRequestMatcher to work correctly
    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
		//plain text
		/*
		return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString(); // Return the raw password as is
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.toString().equals(encodedPassword); // Compare raw password with stored password
            }
        };
        */
		return new BCryptPasswordEncoder();
    }
}
