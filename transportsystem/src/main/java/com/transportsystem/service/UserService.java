package com.transportsystem.service;

import java.util.List;

import com.transportsystem.entity.User;
import com.transportsystem.exception.UserNotFoundException;

public interface UserService {

	public List<User> findAll();
	
	public User findById(int id);
	
	public void save(User user);
	
	public void deleteById(int id);
	
	public User findByEmail(String email);
	
	public boolean userExists(String email);
}
