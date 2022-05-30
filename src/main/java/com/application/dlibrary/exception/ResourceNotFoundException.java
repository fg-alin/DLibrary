package com.application.dlibrary.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4372590862909853742L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}