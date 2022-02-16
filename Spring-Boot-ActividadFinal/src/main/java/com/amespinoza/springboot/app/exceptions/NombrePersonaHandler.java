package com.amespinoza.springboot.app.exceptions;

import java.util.Date;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.amespinoza.springboot.app.controller.PersonaController;


@ControllerAdvice(assignableTypes = PersonaController.class)
public class NombrePersonaHandler {
	
@ExceptionHandler({PersonaExisteException.class})
	
	public ResponseEntity<ErrorDetails> globalExceptionHandler(PersonaExisteException  e, WebRequest request){
		
		
		
		ErrorDetails errors = new ErrorDetails(new Date(), "Error 800" ,e.getMessage(),  request.getDescription(false));
		return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
	}

}
