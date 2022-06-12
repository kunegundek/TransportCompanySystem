package com.transportsystem.user.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.transportsystem.role.entity.Role;
import com.transportsystem.truck.entity.Truck;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	//@NotNull(message="is required")
	@NotBlank(message = "First name can not be empty")
	@Column(name="first_name", nullable = false, length = 45)
	private String firstName;
	
	
	//@NotNull(message="is required")
	@NotBlank(message = "Last name can not be empty")
	@Column(name="last_name", nullable = false, length = 45)
	private String lastName;
	
	//@NotNull(message="is required")
	@NotBlank(message = "Email can not be empty")
	@JsonIgnore
	@Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "Incorrect email address")
	@Column(name="email", nullable = false, unique = true, length = 45)
	private String email;
	
	//@NotNull(message="is required")
	@Size(min=1, message="is required")
	@NotBlank(message="Password can not be empty")
	@JsonIgnore
	@Column(name="password", nullable = false, length=64)
	private String password;
	
	@Column(name="phone_number", length=22)
	private String phoneNumber;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name="users_roles",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="role_id")
			)
	private Set<Role> roles = new HashSet<>();
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(
			name="user_trucks",
			joinColumns = @JoinColumn(name="id_user"),
			inverseJoinColumns = @JoinColumn(name="id_truck")
			)
	private Truck truck;
}
