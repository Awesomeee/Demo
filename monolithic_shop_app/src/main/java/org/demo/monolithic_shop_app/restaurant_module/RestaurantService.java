package org.demo.monolithic_shop_app.restaurant_module;

import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
	
	/*
	 * book food service for a small group (1-3 tables)
	 */
	public int bookTable() {
		return 0;
	}
	
	/*
	 * book food service for a large group ( larger than 3 tables)
	 */
	public int bookParty() {
		return 0;
	}
	
	public int getMenu() {
		return 0;
	}

}
