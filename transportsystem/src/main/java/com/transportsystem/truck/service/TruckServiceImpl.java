package com.transportsystem.truck.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.transportsystem.truck.entity.Truck;
import com.transportsystem.truck.repository.TruckRepository;

@Service
public class TruckServiceImpl implements TruckService {

	private TruckRepository truckRepository;
	
	public TruckServiceImpl(TruckRepository truckRepository) {
		this.truckRepository = truckRepository;
	}

	@Override
	public Truck findById(int id) {
		
		return truckRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("Did not found an truck with id " + id));
	}

	@Override
	public List<Truck> findAll() {
		return truckRepository.findAll();
	}

	@Override
	public Truck save(Truck truck) {
		return truckRepository.save(truck);
	}

	@Override
	public Truck deleteById(int id) {
		
		Truck truck = this.findById(id);
		truckRepository.deleteById(id);
		
		return truck;
	}

}
