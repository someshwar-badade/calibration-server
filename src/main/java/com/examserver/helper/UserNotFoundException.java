package com.examserver.helper;

public class UserNotFoundException extends Exception {
	public UserNotFoundException() {
		super("User with this Username is already ther in DB !! try with another Username.");
	}
	public UserNotFoundException(String msg) {super(msg);}
}
