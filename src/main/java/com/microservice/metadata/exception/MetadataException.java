package com.microservice.metadata.exception;

import org.springframework.http.HttpStatus;

public class MetadataException extends Exception{
	
	private static final long serialVersionUID = 6171139676088678144L;
	
	private HttpStatus httpStatus;
	private String message;
	
	
	public MetadataException(HttpStatus httpStatus, String message) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
	}


	public HttpStatus getHttpStatus() {
		return httpStatus;
	}


	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
