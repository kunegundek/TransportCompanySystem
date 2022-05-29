package com.transportsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transportsystem.dao.RoleRepository;
import com.transportsystem.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {

	private RoleRepository roleRepository;
	
	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	@Override
	public Role finbById(int id) {
		
		Optional<Role> result = roleRepository.findById(id);
		
		Role role = null;
		
		if(result.isPresent()) {
			role = result.get();
		}
		else {
			throw new RuntimeException("Rule (id: "  + id + ") not found");
		}
		
		return role;
	}

}
