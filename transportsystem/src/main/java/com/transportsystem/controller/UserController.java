package com.transportsystem.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.transportsystem.entity.User;
import com.transportsystem.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/list")
	public String listUsers(Model model) {
		
		List<User> users = userService.findAll();
		
		model.addAttribute("users", users);
		
		return "/users/list-users";
	}
	
	@GetMapping("/userAdd")
	public String formForAdd(Model model) {
		
		User user = new User();
		
		model.addAttribute("user", user);
		
		return "users/user-form";
	}
	
	@GetMapping("/userUpdate")
	public String formForUpdate(@RequestParam("userId") int id, Model model) {
		
		User user = userService.findById(id);
		
		model.addAttribute("user", user);
		
		return "users/user-form";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute("user") User user) {
		
		// saving user
		userService.save(user);
		
		// redirect to list
		return "redirect:/users/list";
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int id) {
		
		// deleting user by id
		userService.deleteById(id);
		
		//redirect to list
		return "redirect:/users/list";
	}
}	
