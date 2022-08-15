package com.example.springboot.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springboot.app.entity.User;

@Service
public interface UserService {
	
	User saveUser(User user);
	
	User getUser(int userId);
	
	List<User> getAllUsers();

}
