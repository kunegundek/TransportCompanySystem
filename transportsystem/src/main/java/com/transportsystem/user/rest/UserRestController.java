package com.transportsystem.user.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transportsystem.truck.entity.Truck;
import com.transportsystem.truck.service.TruckService;
import com.transportsystem.user.entity.User;
import com.transportsystem.user.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

	private UserService userService;
	private TruckService truckService;
	
	public UserRestController(UserService userService,
							  TruckService truckService) {
		this.userService = userService;
		this.truckService = truckService;
	}
	
	@PostMapping("/{userId}/truck")
	public Truck addTruck(@RequestBody Truck theTruck, @PathVariable int userId) {
		
		User user = userService.findById(userId);
		
		
		Truck truck = truckService.save(theTruck);
		
		user.setTruck(truck);
		userService.save(user);
		
		return truck;
	}
	
	@PutMapping("/{userId}/truck")
	public Truck updateTruck(@RequestBody Truck theTruck, @PathVariable int userId) {
		
		User user = userService.findById(userId);
		user.setTruck(theTruck);
		
		userService.save(user);
		
		return user.getTruck();
	}
}
