package com.amespinoza.springboot.app.exceptions;

import java.util.Date;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.amespinoza.springboot.app.controller.SaludoController;

@ControllerAdvice
public class SaludoHandler {
	
	@ExceptionHandler({SaludoExisteException.class})
	
	public ResponseEntity<ErrorDetails> globalExceptionHandler(SaludoExisteException  e, WebRequest request){
		
	
		
		ErrorDetails errors = new ErrorDetails(new Date(), "ERROR 900", e.getMessage(),  request.getDescription(false));
		return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
	}

		@ExceptionHandler({SaludoNoExisteException.class})
		
		public ResponseEntity<ErrorDetails> globalExceptionHandler(SaludoNoExisteException  e, WebRequest request){
			
		
			
			ErrorDetails errors = new ErrorDetails(new Date(), "ERROR 4500", e.getMessage(),  request.getDescription(false));
			return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
		}
	
	

}
