package com.transportsystem.truck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transportsystem.truck.entity.Truck;

public interface TruckRepository extends JpaRepository<Truck, Integer> {

}
