package com.acceldata.acceldatatest.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.acceldata.acceldatatest.exception.DataStoreExcpetion;
import com.acceldata.acceldatatest.exception.KeyNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(DataStoreExcpetion.class) 
	public ResponseEntity<ErrorMessage> handleException(DataStoreExcpetion e) {
		
		ErrorMessage err=new ErrorMessage("key Already exits");
		return new ResponseEntity<ErrorMessage>(err,new HttpHeaders(),HttpStatus.CONFLICT);
    }
	
	@ExceptionHandler(KeyNotFoundException.class) 
	public ResponseEntity<ErrorMessage> handleException(KeyNotFoundException e) {
		
		ErrorMessage err=new ErrorMessage("key does not  exits");
		return new ResponseEntity<ErrorMessage>(err,new HttpHeaders(),HttpStatus.NOT_FOUND);
    }
	
}
class ErrorMessage{
	private String message;

	public ErrorMessage(String message) {
		super();
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}