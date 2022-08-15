package com.example.springboot.app.error.handler;

public class InvalidUserException extends Exception{

	
	private static final long serialVersionUID = 1L;

	
	public InvalidUserException(String message) {
		super(message);
	}
}
