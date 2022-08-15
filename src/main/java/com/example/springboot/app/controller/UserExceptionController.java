package com.example.springboot.app.controller;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.springboot.app.error.handler.InvalidUserException;

@ControllerAdvice
public class UserExceptionController {
	
	@ExceptionHandler(value = InvalidUserException.class)
	public ResponseEntity<Object> handleException(InvalidUserException exception){
		
		
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
		
		
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleValidationException(ConstraintViolationException exception){
		
		StringBuilder builder = new StringBuilder();
		
		exception.getConstraintViolations().stream().forEach(violation -> builder.append(violation.getPropertyPath() +" "+ violation.getMessage()));
		
		return ResponseEntity.badRequest().body(builder.toString());
	}

}
