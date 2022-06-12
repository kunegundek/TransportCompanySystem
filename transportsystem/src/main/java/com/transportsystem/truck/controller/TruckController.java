package com.transportsystem.truck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.transportsystem.truck.service.TruckService;

@Controller
@RequestMapping("/truck")
public class TruckController {

	private TruckService truckService;
	
	public TruckController(TruckService truckService) {
		this.truckService = truckService;
	}

}
