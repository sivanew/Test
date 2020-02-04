package com.hcl.customer.exception;

public class CustomerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public CustomerException() {

	}

	public CustomerException(String errorMessage) {
		super(errorMessage);
	}

}
