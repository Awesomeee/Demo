package org.demo.monolithic_shop_app.web_service_module.shop;

import org.demo.monolithic_shop_app.security_module.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
public class UserApi {
	
	@GetMapping("/csrf-token")
    public CsrfToken csrf(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());
    }
	
	@GetMapping("/api/users")
	public String queryUserList(@RequestParam(name = "page", required = false) int page,@RequestParam(name = "size", required = false) int size,@RequestParam(name = "sort", required = false) String sort,@RequestParam(name = "direction", required = false) String direction) {
		return "empty";
	}
	
	@PostMapping("/api/users")
	public String addUser(@Valid @RequestBody(required = true) UserDto user) {
		return "empty";
	}
	
	@GetMapping("/api/users/{user-category}")
	@ResponseStatus(code = HttpStatus.OK)
	public String getUser(@PathVariable(name = "user-category", required = true) String userCategory) {
		return "empty";
	}
	
	@PatchMapping("/api/users/{user-id}")
	public String updatePartiallyUserResource(@PathVariable(name="user-id", required = true) String userId) {
		return "empty";
	}
	
	@PutMapping("/api/users/{user-id}")
	public String updateUserResource(@PathVariable(name="user-id", required = true) String userId, @RequestBody UserDto user) {
		return "empty";
	}
	
	@DeleteMapping("/api/users/{user-id}")
	public String deleteUserResource(@PathVariable(name="user-id", required = true) String userId) {
		return "empty";
	}

}
