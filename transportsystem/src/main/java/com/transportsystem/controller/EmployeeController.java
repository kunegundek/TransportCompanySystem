package com.transportsystem.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.transportsystem.entity.Employee;
import com.transportsystem.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/list")
	public String listUsers(Model model) {
		
		List<Employee> employees = employeeService.findAll();
		
		model.addAttribute("employees", employees);
		
		return "/employees/list-employees";
	}
	
	@GetMapping("/employeeAdd")
	public String formForAdd(Model model) {
		
		Employee employee = new Employee();
		
		model.addAttribute("employee", employee);
		
		return "employees/employee-form";
	}
	
	@GetMapping("/employeeUpdate")
	public String formForUpdate(@RequestParam("employeeId") int id, Model model) {
		
		Employee employee = employeeService.findById(id);
		
		model.addAttribute("employee", employee);
		
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute("employee") Employee employee) {
		
		// saving user
		employeeService.save(employee);
		
		// redirect to list
		return "redirect:/employees/list";
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("employeeId") int id) {
		
		// deleting user by id
		employeeService.deleteById(id);
		
		//redirect to list
		return "redirect:/employees/list";
	}
}	
