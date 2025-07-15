package org.demo.monolithic_shop_app.security_module;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
public class SecurityConfiguration {

	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
        http
            // Disable CSRF for H2 console
            .csrf(csrf -> csrf.ignoringRequestMatchers(antMatcher("/h2-console/**"), antMatcher("/test/**")))
            // Allow frames from the same origin (essential for H2 console)
            .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()))
            // Permit all requests to H2 console path
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(antMatcher("/h2-console/**"), antMatcher("/guest/**"), antMatcher("/test/**")).permitAll()
                .anyRequest().authenticated() // Protect other endpoints
            )
            .formLogin(Customizer.withDefaults());
        return http.build();
    }

    // This bean is needed for MvcRequestMatcher to work correctly
    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }
}
