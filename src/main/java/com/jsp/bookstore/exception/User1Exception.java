package com.jsp.bookstore.exception;

public class User1Exception extends RuntimeException{
	private String message;
	
	public User1Exception(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	
}
