package com.transportsystem.service;

import java.util.List;

import com.transportsystem.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee user);
	
	public void deleteById(int id);
}
