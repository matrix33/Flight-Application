package com.debi.exception;

import org.springframework.http.HttpStatus;

public class ApiError {
	private HttpStatus status;
	private String errorCode;
	private String errorMessage;
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public ApiError(HttpStatus status, String errorCode, String errorMessage) {
		super();
		this.status = status;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

}
