package com.nagarro.training.TicketManagementPortal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(value = CustomException.class)
	final public ResponseEntity<String> exception(CustomException ex) {
		return new ResponseEntity<String>("TICKET NOT FOUND", HttpStatus.BAD_REQUEST);

	}

}
