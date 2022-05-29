package com.transportsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.transportsystem.entity.User;
import com.transportsystem.user.MyUserDetails;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = userService.findByEmail(email);
		
		return new MyUserDetails(user);
	}

}
