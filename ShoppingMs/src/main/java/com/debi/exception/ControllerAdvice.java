package com.debi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler{
	@ExceptionHandler(value = BsnsObjException.class)
	protected ResponseEntity<ApiError> handleBsnsObjExcep(RuntimeException ex, WebRequest req){
		ApiError error = new ApiError(HttpStatus.NOT_FOUND, "FL_404", ex.getLocalizedMessage());
		return new ResponseEntity<>(error, error.getStatus());
	}
	
}
