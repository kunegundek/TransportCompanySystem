package com.transportsystem.truck.service;

import java.util.List;

import com.transportsystem.truck.entity.Truck;

public interface TruckService {
	
	public List<Truck> findAll();
	
	public Truck findById(int id);
	
	public Truck save(Truck truck);
	
	public Truck deleteById(int id);
}
