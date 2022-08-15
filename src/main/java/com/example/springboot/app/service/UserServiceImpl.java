package com.example.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springboot.app.entity.User;
import com.example.springboot.app.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	 @Override
	public User saveUser(User user) {
		
		 
		return userRepository.save(user);
		
	}
	 
	 @Override
	public User getUser(int userId) {
		
		return userRepository.findById(userId).get();
	}
	 
	 @Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}
}
