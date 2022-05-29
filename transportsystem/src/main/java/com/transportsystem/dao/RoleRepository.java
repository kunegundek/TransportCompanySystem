package com.transportsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transportsystem.entity.Role;

public interface RoleRepository extends  JpaRepository<Role, Integer> {
	
	
}
