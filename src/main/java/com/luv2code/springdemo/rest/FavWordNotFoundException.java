package com.luv2code.springdemo.rest;

public class FavWordNotFoundException extends RuntimeException {

	public FavWordNotFoundException() {
	}

	public FavWordNotFoundException(String message) {
		super(message);
	}

	public FavWordNotFoundException(Throwable cause) {
		super(cause);
	}

	public FavWordNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public FavWordNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
