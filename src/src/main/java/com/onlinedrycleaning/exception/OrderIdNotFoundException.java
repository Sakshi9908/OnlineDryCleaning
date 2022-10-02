package com.onlinedrycleaning.exception;

public class OrderIdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;
	
	public OrderIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public OrderIdNotFoundException() {
		
	}

	public OrderIdNotFoundException(Throwable cause) {
		super(cause);
		
	}

	public OrderIdNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public OrderIdNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	
}
