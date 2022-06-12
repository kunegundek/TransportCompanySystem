package com.transportsystem.user.rest.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.transportsystem.helper.ExceptionHelper;
import com.transportsystem.user.rest.UserErrorResponse;

@ControllerAdvice
public class UserRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handleException(DataIntegrityViolationException exc){
		
		UserErrorResponse error = new UserErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("Incorrect request body");
		error.setDetails(ExceptionHelper.getCauseMessage(exc));
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handleException(Exception exc){
		
		UserErrorResponse error = new UserErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}
