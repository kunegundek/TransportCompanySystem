package com.transportsystem.service;

import java.util.List;

import com.transportsystem.entity.User;

public interface UserService {

	public List<User> findAll();
	
	public User findById(int id);
	
	public void save(User user);
	
	public void deleteById(int id);
}
