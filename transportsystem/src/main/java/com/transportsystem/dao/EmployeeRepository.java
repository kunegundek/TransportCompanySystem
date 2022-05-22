package com.transportsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transportsystem.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public List<Employee> findAll();
}
