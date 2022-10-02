package com.onlinedrycleaning.exception;

public class CustomerNameAlreadyExistException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNameAlreadyExistException(String message) {
		super(message);
	}

}