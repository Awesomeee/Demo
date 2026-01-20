package org.demo.monolithic_shop_app.view_module;

import java.util.HashMap;
import java.util.Map;

import org.demo.monolithic_shop_app.security_module.User;
import org.demo.monolithic_shop_app.security_module.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ShopStoreView {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/guest/shop")
	public String ShopView() {
		String mode = "SIMPLE";
		if(mode == "SIMPLE")
			return "shop_simple_gui";
		else if(mode == "EXQUISITE")
			//for future update, currently it is just an empty page
			return "shop_exquisite_gui";
		else {
			//default
			return "shop_simple_gui";
		}
	}
	
	@GetMapping(path = "/employee/workshop")
	public String WorkShopView(HttpServletRequest request,Model model) {
		//get username of current user
		Authentication authentication = (Authentication) request.getUserPrincipal();
		String username = authentication.getName();
		
		model.addAttribute("username", username);
		return "workshop_simple_gui";
	}
	
	@GetMapping(path = "/user_login")
	public String LoginView() {
		return "user_login";
	}
	
	@GetMapping(path = "/user_logout")
	public String LogoutView() {
		return "user_logout";
	}
	
	@GetMapping(path = "/user_register")
	public String RegisterView() {
		return "user_register";
	}
	
	@PostMapping(path = "/register")
	public String RegisterUser(@RequestParam("username") String username, @RequestParam("password") String password
			, @RequestParam("email") String email,Model model) {
		User user = new User();
		user.setUserName(username);
		user.setUserPassword(password);
		user.setEmail(email);
		boolean isExisted = userService.checkUserExistence(username);
		if(isExisted) {
			model.addAttribute("error", "true");
		} else {
			int result = userService.registerNewUser(user);
			if(result == 1)
				model.addAttribute("success", "true");
			else
				model.addAttribute("error", "true");
		}
		return "user_register_result";
	}
	
	@GetMapping(path = "/user_change_password")
	public String ChangePasswordView() {
		return "user_change_password";
	}
	
	@PostMapping(path = "/change_password")
	public String ChangePassword(@RequestParam("username") String username, @RequestParam("password") String password
			, @RequestParam("new_password") String newPassword,Model model) {
		
		boolean isValid = true;
		User checkingUser = userService.findUserByUsername(username);
		//do the authentication to check whether user is real or user does not know its password. If user fail to deliver its password then he/she might not the real user
		if(!checkingUser.getUserPassword().equals(password))
			isValid = false;
		//new password must not equal to old one.
		if(password.equals(newPassword))
			isValid = false;
		
		if(!isValid) {
			model.addAttribute("error", "true");
		} else {		
			int result = userService.changePassword(username, newPassword);
			if(result == 1)
				model.addAttribute("success", "true");
			else
				model.addAttribute("error", "true");
		}
		return "user_change_password_result";
	}

}
