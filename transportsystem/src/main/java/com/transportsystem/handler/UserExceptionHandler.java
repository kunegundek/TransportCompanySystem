package com.transportsystem.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.function.EntityResponse;

import com.transportsystem.exception.UserNotFoundException;

@ControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public  ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) 
	{
		return null;
		//return new ResponseEntity<Object>()
	}
}
