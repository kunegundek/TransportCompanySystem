package com.transportsystem.truck.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.transportsystem.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="truck")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Truck {
	
	@Id
	@Column(name="id_truck")
	private int id;
	
	private String brand;
	
	private String model;
	
	private int enginePower;
	
	private long mileage;
	
	@OneToMany
	private List<User> user = new ArrayList<User>();

}
