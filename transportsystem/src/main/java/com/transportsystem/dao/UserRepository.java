package com.transportsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transportsystem.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public List<User> findAll();
}
