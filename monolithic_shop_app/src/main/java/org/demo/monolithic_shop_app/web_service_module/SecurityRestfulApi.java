package org.demo.monolithic_shop_app.web_service_module;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SecurityRestfulApi {
	
	@GetMapping("/csrf-token")
    public CsrfToken csrf(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());
    }
	
	@GetMapping("/api/users")
	public String queryUserList(@RequestParam(name = "page", required = false) int page,@RequestParam(name = "size", required = false) int size,@RequestParam(name = "sort", required = false) String sort,@RequestParam(name = "direction", required = false) String direction) {
		return "ok";
	}
	
	@PostMapping("/api/users")
	public String addUser() {
		return "ok";
	}
	
	@GetMapping("/api/users/{user-category}")
	public String getUser() {
		return "ok";
	}

}
