package com.transportsystem.user.rest;

import lombok.Data;

@Data
public class UserErrorResponse {

	private int status;
	private String message;
	private String details;
	private long timeStamp;

}
