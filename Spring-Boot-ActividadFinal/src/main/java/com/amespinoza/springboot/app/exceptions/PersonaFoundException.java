package com.amespinoza.springboot.app.exceptions;

public class PersonaFoundException extends RuntimeException {
	

	public PersonaFoundException() {
       
      super("No hay personas en la base de datos!");
    }

    
}
