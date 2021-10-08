package com.examserver.helper;

public class UserFoundException extends Exception {
	public UserFoundException() {
		super("User with this Username is already ther in DB !! try with another Username.");
	}
	public UserFoundException(String msg) {super(msg);}
}
