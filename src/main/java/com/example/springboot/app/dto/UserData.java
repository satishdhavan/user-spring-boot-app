package com.example.springboot.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserData {

	
	private String name;
	private String email;
	private String mobile;
	private String gender;
	private int age;
	private String nationality;
	
}
