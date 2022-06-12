package com.transportsystem.user.service;

import java.util.List;

import com.transportsystem.user.entity.User;

public interface UserService {

	public List<User> findAll();
	
	public User findById(int id);
	
	public User save(User user);
	
	public void deleteById(int id);
	
	public User findByEmail(String email);
	
	public boolean userExists(String email);
}
