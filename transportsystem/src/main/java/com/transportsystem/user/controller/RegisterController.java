package com.transportsystem.user.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.transportsystem.role.entity.Role;
import com.transportsystem.role.service.RoleService;
import com.transportsystem.user.entity.User;
import com.transportsystem.user.service.UserService;

@Controller
@ControllerAdvice
@RequestMapping("/register")
public class RegisterController {
	
	private UserService userService;
	private RoleService roleService;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	public RegisterController(UserService userService, RoleService roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	
	@GetMapping("/showRegisterForm")
	public String showRegisterForm(Model model) {
		
		model.addAttribute("user", new User());
		return "registration-form";
	}
	
	//Rejestracja nowego użytkownika
	@PostMapping("/process_register")
	public String processRegister(@Valid @ModelAttribute("user")  User user,
								  BindingResult bindingResult,
								  Model model) {
		
		logger.info("Processing registration form for: " + user.getEmail());
		logger.info("errors => " + bindingResult.hasErrors());
		if(bindingResult.hasErrors()) {
			model.addAttribute("user", new User());
			model.addAttribute("registrationError", "Please fill in all fields correctly.");
			
			logger.warning("Fields can't be empty");
			return "registration-form";
		}
		
		if(doesUserExist(user.getEmail())) {
			model.addAttribute("user", new User());
			model.addAttribute("registrationError", "This email is busy");
			
			logger.warning("Email already exists.");
			
			return "registration-form";
		}
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		
		/*Roles id's:
		 * 1 -> EMPLOYEE
		 * 2 -> CUSTOMER
		 * 3 -> ADMIN
		 * 4 -> USER
		*/
		
		Set<Role> roles = new HashSet<Role>();
		Role roleUser = roleService.finbById(4);
		
		roles.add(roleUser);
		
		user.setRoles(roles);
		user.setPassword(encodedPassword);
		
		userService.save(user);
		
		logger.info("Successfully created user: " + user.getEmail());
		
		return "registration-confirmation";
	}
	
	private boolean doesUserExist(String email) {
		
		logger.info("Checking if user exists: " + email);
		
		boolean exists = false;
		
		try {
			exists = userService.userExists(email);
		}
		catch(RuntimeException exception) {
			logger.warning(exception.getMessage());
		}
		
		logger.info("User: " + email + ", exists: " + exists);
		
		return exists;
	}
	
	@ExceptionHandler(value = IllegalArgumentException.class)
	public String handleIllegalArgumentException() {
		return "exc";
	}
}