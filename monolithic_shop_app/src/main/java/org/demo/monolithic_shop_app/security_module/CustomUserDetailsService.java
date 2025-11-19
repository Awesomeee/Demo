package org.demo.monolithic_shop_app.security_module;

import java.util.ArrayList;
import java.util.List;

import org.demo.monolithic_shop_app.data_module.database.UserTable;
import org.demo.monolithic_shop_app.data_module.database.UserTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserTableRepository userTableRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("developer"));
		authorities.add(new SimpleGrantedAuthority("admin"));
		authorities.add(new SimpleGrantedAuthority("business-user"));
		
		UserTable user = userTableRepository.findByUserName(username);
		System.out.println(user.getUserName() + " " + user.getUserPassword());
		
		return new User(user.getUserName(), passwordEncoder.encode(user.getUserPassword()), authorities);
	}

}
