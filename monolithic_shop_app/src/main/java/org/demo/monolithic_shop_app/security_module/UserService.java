package org.demo.monolithic_shop_app.security_module;

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
	
	public void checkUserExistence() {}
	
	public void registerNewUser() {}
	
	public void activeUser() {}
	
	public void reportPasswordForgetting() {}
	
	public void changePassword() {}
	
	public void createUser() {}
	
	public void editUser() {}
	
	public void findUser() {}
	
	public void deleteUser() {}

}
