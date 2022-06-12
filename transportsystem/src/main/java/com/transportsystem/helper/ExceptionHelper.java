package com.transportsystem.helper;

public class ExceptionHelper {
	
	//Method return message from top-level exception - I use it for getting details about exception from api
	public static String getCauseMessage(Throwable t) {

	    Throwable cause = t;
	    while (cause.getCause() != null) {
	        cause = cause.getCause();
	    }
	
	    return cause.getMessage();
	}
}
