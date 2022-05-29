package com.transportsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {

	@Id
	@Column(name="role_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	public Role() {
	}
	
	public Role(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

}
