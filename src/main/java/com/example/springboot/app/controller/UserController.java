package com.example.springboot.app.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.app.dto.UserData;
import com.example.springboot.app.entity.User;
import com.example.springboot.app.error.handler.InvalidUserException;
import com.example.springboot.app.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getUsers(){
		
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
		
	}
	
	@GetMapping("/userById")
	public ResponseEntity<User> getUsers(@RequestParam int id) throws InvalidUserException{
		
		User user=null;
		try {
			
		user=	userService.getUser(id);
			
		}catch(NoSuchElementException exception) {
			
			throw new InvalidUserException("No User exists with user id: "+ id);
		}
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserData userData ){
		
		User user = User.build(0, userData.getName(), userData.getEmail(), userData.getMobile(),
				userData.getGender(), userData.getAge(), userData.getNationality());
		
		 user = userService.saveUser(user);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
		
	}

}
