package com.transportsystem.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transportsystem.user.entity.User;
import com.transportsystem.user.repository.UserRepository;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(int id) {
		
		return userRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("Did not find user id - " + id));
	}

	@Override
	public User save(User user) {
		userRepository.save(user);
		
		return user;
	}

	@Override
	public void deleteById(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public User findByEmail(String email) {
		
		Optional<User> result = Optional.ofNullable(userRepository.findByEmail(email));
	
		User user = null;
		
		if(result.isPresent()) {
			user = result.get();
		}
		else {
			throw new EntityNotFoundException("Did not find user with email " + email);
		}
		
		return user;
	}

	@Override
	public boolean userExists(String email) {
		
		User user = null;

		user = this.findByEmail(email);
	
		if(user != null) {
			return true;
		}
		
		return false;
	}
	
	
}
