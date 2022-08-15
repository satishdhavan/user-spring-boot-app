package com.example.springboot.app.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER_TBL")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor

public class User {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int userId;
	@NotNull
	@Length(min = 1, max=100)
	private String name;
	@Email
	private String email;
	@Length(min=10, max=10)
	private String mobile;
	@NotBlank
	private String gender;
	@Min(value = 1)
	@Max(value=100)
	private int age;
	@NotBlank
	private String nationality;
	

}
