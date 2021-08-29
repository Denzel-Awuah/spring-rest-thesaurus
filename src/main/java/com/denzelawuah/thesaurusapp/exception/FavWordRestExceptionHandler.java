package com.denzelawuah.thesaurusapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FavWordRestExceptionHandler {

	// Add an exception handler for FavWordNotFoundException
	
	@ExceptionHandler
	public ResponseEntity<FavWordErrorResponse> handleException(FavWordNotFoundException exc) {
		
		// create FavWordErrorResponse
		
		FavWordErrorResponse error = new FavWordErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
	// Add another exception handler ... to catch any exception (catch all)

	@ExceptionHandler
	public ResponseEntity<FavWordErrorResponse> handleException(Exception exc) {
		
		// create FavWordErrorResponse
		
		FavWordErrorResponse error = new FavWordErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}





