package org.demo.monolithic_shop_app.security_module;

import java.util.List;

public class UserDto {
	
	private List<User> users;
	
	public UserDto() {}
	

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
