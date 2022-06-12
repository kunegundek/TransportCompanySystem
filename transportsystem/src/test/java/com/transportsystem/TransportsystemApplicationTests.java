package com.transportsystem;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.transportsystem.truck.entity.Truck;
import com.transportsystem.truck.service.TruckService;
import com.transportsystem.user.entity.User;
import com.transportsystem.user.service.UserService;

@SpringBootTest
class TransportsystemApplicationTests {
	
	@Autowired
	TruckService truckService;
	
	@Autowired
	UserService userService;
	
}
