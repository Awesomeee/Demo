package org.demo.monolithic_shop_app.web_service_module.shop;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.demo.monolithic_shop_app.security_module.User;
import org.demo.monolithic_shop_app.security_module.UserDto;
import org.demo.monolithic_shop_app.security_module.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
public class UserApi {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/csrf-token")
    public CsrfToken csrf(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());
    }
	
	@GetMapping("/api/users")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public UserDto queryUserList(@RequestParam(name = "page", required = false) int page,@RequestParam(name = "size", required = false) int size,@RequestParam(name = "sort", required = false) String sort,@RequestParam(name = "direction", required = false) String direction) {
		return userService.queryAllUsers(page, size, sort, direction);
	}
	
	@PostMapping("/api/users")
	public String addUser(@Valid @RequestBody(required = true) User user) {
		int result = userService.createUser(user);
		return result + "";
	}
	
	@PostMapping("/api/users/register")
	public String registerUser(@Valid @RequestBody(required = true) User user) {
		int result = userService.registerNewUser(user);
		return result + "";
	}
	
	@GetMapping("/api/users/activation-code")
	public String getActivationCode(@RequestParam(name = "username", required = true) String username) {
		User user = userService.findUserByUsername(username);
		String encodeDataString = username+":"+user.getUserPassword();
		byte[] encodeBytes = Base64.getEncoder().encode(encodeDataString.getBytes());
		String encodeString = new String(encodeBytes, StandardCharsets.UTF_8);
		return "activated_code:" + encodeString;
	}
	
	/*
	 * This api is used for the user to activate the his/her user account
	 * activated-code is a base64 String that contain the information of 
	 * username and password with the structure as "username:password"
	 */
	@GetMapping("/api/users/activate")
	public String activateUser(@RequestParam(name = "activated_code", required = true) String activatedCode) {
		int result = 0;
		byte[] decodeBytes = Base64.getDecoder().decode(activatedCode);
		String decodeString = new String(decodeBytes, StandardCharsets.UTF_8);
		String username = decodeString.split(":")[0];
		String password = decodeString.split(":")[1];
		if(userService.validateUserAccount(username, password)) {
			result = userService.activeUser(username);
		}
		return result + "";
	}
	
	/*
	 * This api is used for the admin to activate a user account
	 */
	@PostMapping("/api/users/activate")
	public String activateUser(@Valid @RequestBody(required = true) User user) {
		int result = userService.activeUser(user);
		return result + "";
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
	public String updateUserResource(@PathVariable(name="user-id", required = true) String userId, @RequestBody User user) {
		return userService.editUser(userId, user) + "";
	}
	
	@DeleteMapping("/api/users/{user-id}")
	public String deleteUserResource(@PathVariable(name="user-id", required = true) String userId) {
		return userService.deleteUser(userId) + "";
	}

}
