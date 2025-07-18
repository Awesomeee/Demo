package org.demo.monolithic_shop_app.view_module;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ShopStoreView {
	
	@GetMapping(path = "/guest/shop")
	public String ShopView() {
		String mode = "SIMPLE";
		if(mode == "SIMPLE")
			return "shop_simple_gui";
		else if(mode == "EXQUISITE")
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
		return "workshop";
	}

}
