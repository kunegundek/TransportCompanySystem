package com.transportsystem.user.controller;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.transportsystem.user.entity.User;
import com.transportsystem.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private UserService userService;
	
	public UserController(UserService employeeService) {
		this.userService = employeeService;
	}
	
	@GetMapping("/list")
	public String listUsers(Model model) {
		
		List<User> users = userService.findAll();
		
		model.addAttribute("users", users);
		
		return "/user/list-employees";
	}
	
	@GetMapping("/add")
	public String formForAdd(Model model) {
		
		User user = new User();
		
		model.addAttribute("user", user);
		
		return "user/user-form";
	}
	
	@GetMapping("/update")
	public String formForUpdate(@RequestParam("userId") int id, Model model) {
		
		User user = userService.findById(id);
		
		model.addAttribute("user", user);
		
		return "user/user-form";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute("user") User user) {
		
		// saving user
		User userSaved = userService.save(user);
		
		// redirect to list
		return "redirect:/user/list";
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int id) {
		
		// deleting user by id
		userService.deleteById(id);
		
		//redirect to list
		return "redirect:/user/list";
	}
}	
