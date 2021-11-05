package com.debi.exception;

import org.springframework.http.HttpStatus;

public class BsnsObjException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HttpStatus status ;

	public BsnsObjException(String message, HttpStatus status) {
		super(message);
		this.setStatus(status);
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
