package com.transportsystem.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
