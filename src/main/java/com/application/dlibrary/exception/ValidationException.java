package com.application.dlibrary.exception;

public class ValidationException extends RuntimeException {

	
	private static final long serialVersionUID = 3480357252611464043L;

	public ValidationException(String message) {
		super(message);
	}
}