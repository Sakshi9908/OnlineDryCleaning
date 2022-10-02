package com.onlinedrycleaning.exception;

public class WrongUsernameAndPassword extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WrongUsernameAndPassword(String message) {
		super(message);
	}
}
