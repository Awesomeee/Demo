package org.demo.monolithic_shop_app.security_module;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.demo.monolithic_shop_app.data_module.database.UserTable;
import org.demo.monolithic_shop_app.data_module.database.UserTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/*
 * Author: duyl
 * created date: Wed 19 Nov
 * Đối với user như khách hàng và nhân viên thì sẽ dùng registerNewUser và activeUser để tạo account mới
 * , Còn đối với user admin thì không cần phải request và active băng cách confirm bằng email mà sẽ dùng
 * thẳng hàm createUser.
 */
@Service
public class UserService {
	
	@Autowired
	private UserTableRepository userTableRepository;
	
	public boolean checkUserExistence(String userName) {
		boolean existed = true;
		UserTable user = userTableRepository.findByUserName(userName);
		if(user == null)
			existed = false;
		return existed;
	}
	
	public boolean validateUserAccount(String username, String password) {
		boolean existed = true;
		UserTable user = userTableRepository.findByUserName(username);
		if(user == null)
			existed = false;
		else {
			if(!user.getUserPassword().equals(password))
				existed = false;
		}
		return existed;
	}
	
	public int registerNewUser(User user) {
		int result = 1;
		try {
			String userId = UUID.randomUUID().toString();
			UserTable newUser = new UserTable(userId, user.getUserName(), user.getUserPassword(), user.getEmail()
					, user.getPhoneNumber(), user.getAddress(), user.getRole(), user.getPrivilege()
					, user.getTeam(), "REQUESTING");
			userTableRepository.save(newUser);
		} catch (Exception e) {
			result = 0;
			System.err.println(e.getMessage());
		}
		
		return result;
	}
	
	public int activeUser(User userData) {
		int result = 1;
		try {
			UserTable user = userTableRepository.findByUserName(userData.getUserName());
			user.setState("ACTIVE");
		} catch (Exception e) {
			result = 0;
			System.err.println(e.getMessage());
		}
		
		return result;
	}
	
	public int activeUser(String username) {
		int result = 1;
		try {
			UserTable user = userTableRepository.findByUserName(username);
			user.setState("ACTIVE");
			userTableRepository.save(user);
		} catch (Exception e) {
			result = 0;
			System.err.println(e.getMessage());
		}
		
		return result;
	}
	
	public void reportPasswordForgetting() {}
	
	public int changePassword(String username, String newPassword) {
		int result = 1;
		try {
			UserTable user = userTableRepository.findByUserName(username);
			user.setUserPassword(newPassword);
			userTableRepository.save(user);
		} catch (Exception e) {
			result = 0;
			System.err.println(e.getMessage());
		}
		return result;
	}
	
	public int createUser(User user) {
		int result = 1;
		try {
			String userId = UUID.randomUUID().toString();
			UserTable newUser = new UserTable(userId, user.getUserName(), user.getUserPassword(), user.getEmail()
					, user.getPhoneNumber(), user.getAddress(), user.getRole(), user.getPrivilege()
					, user.getTeam(), "ACTIVE");
			userTableRepository.save(newUser);
		} catch (Exception e) {
			result = 0;
			System.err.println(e.getMessage());
		}
		return result;
	}
	
	public int editUser(String id, User user) {
		int result = 1;
		try {
			Optional<UserTable> updateRow = userTableRepository.findById(id);
			updateRow.get().setUserId(user.getUserId());
			updateRow.get().setUserName(user.getUserName());
			updateRow.get().setUserPassword(user.getUserPassword());
			updateRow.get().setEmail(user.getEmail());
			updateRow.get().setPhoneNumber(user.getPhoneNumber());
			updateRow.get().setAddress(user.getAddress());
			updateRow.get().setRole(user.getRole());
			updateRow.get().setPrivilege(user.getPrivilege());
			updateRow.get().setTeam(user.getTeam());
			updateRow.get().setState(user.getState());
			
			userTableRepository.save(updateRow.get());
		} catch (Exception e) {
			result = 0;
			System.err.println(e.getMessage());
		}
		return result;
	}
	
	public UserDto queryAllUsers(int pageNumber, int pageSize, String sortType, String direction) {
		Sort sort = Sort.by(sortType);
		if(direction.equals("asc")) {
			sort = sort.ascending();
		} else if(direction.equals("desc")) {
			sort = sort.descending();
		}
		List<UserTable> rows = userTableRepository.findAll(PageRequest.of(pageNumber, pageSize, sort)).getContent();
		List<User> users = new ArrayList<User>();
		for(int i=0; i<rows.size();i++) {
			User element = new User();
			element.setUserId(rows.get(i).getUserId());
			element.setUserName(rows.get(i).getUserName());
			element.setUserPassword(rows.get(i).getUserPassword());
			element.setEmail(rows.get(i).getEmail());
			element.setPhoneNumber(rows.get(i).getPhoneNumber());
			element.setAddress(rows.get(i).getAddress());
			element.setRole(rows.get(i).getRole());
			element.setPrivilege(rows.get(i).getPrivilege());
			element.setTeam(rows.get(i).getTeam());
			element.setState(rows.get(i).getState());
			
			users.add(element);
		}
		UserDto result = new UserDto();
		result.setUsers(users);
		return result;
	}
	
	public int deleteUser(String id) {
		int result = 1;
		try {
			userTableRepository.deleteById(id);
		} catch(Exception e) {
			result = 0;
			System.err. print(e.getMessage());
		}
		return result;
	}
	
	public User findUserByUsername(String username) {
		UserTable userTable = userTableRepository.findByUserName(username);
		User element = new User();
		element.setUserId(userTable.getUserId());
		element.setUserName(userTable.getUserName());
		element.setUserPassword(userTable.getUserPassword());
		element.setEmail(userTable.getEmail());
		element.setPhoneNumber(userTable.getPhoneNumber());
		element.setAddress(userTable.getAddress());
		element.setRole(userTable.getRole());
		element.setPrivilege(userTable.getPrivilege());
		element.setTeam(userTable.getTeam());
		element.setState(userTable.getState());
		
		return element;
	}

}
