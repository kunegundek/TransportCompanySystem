package com.transportsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transportsystem.dao.EmployeeRepository;
import com.transportsystem.entity.Employee;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository userRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		
		Optional<Employee> result = userRepository.findById(id);
		
		Employee user = null;
		
		if(result.isPresent()) {
			user = result.get();
		}
		else {
			throw new RuntimeException("Did not find user id - " + id);
		}
		
		return user;
	}

	@Override
	public void save(Employee user) {
		userRepository.save(user);
	}

	@Override
	public void deleteById(int id) {
		userRepository.deleteById(id);
	}
	
}
