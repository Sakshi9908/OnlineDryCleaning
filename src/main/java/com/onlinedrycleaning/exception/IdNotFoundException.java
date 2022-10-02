package com.onlinedrycleaning.exception;

public class IdNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdNotFoundException(String msg) {
		super(msg+" id not found");
		
	}
}
