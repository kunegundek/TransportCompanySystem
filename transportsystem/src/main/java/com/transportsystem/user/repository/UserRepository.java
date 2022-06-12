package com.transportsystem.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.transportsystem.user.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public List<User> findAll();
	
	@Query("SELECT u FROM User u WHERE u.email= ?1")
	public User findByEmail(String email);
	
}
