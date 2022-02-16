package com.amespinoza.springboot.app.exceptions;

public class SinPersonasException extends RuntimeException {
	

	public SinPersonasException() {
       
      super("No hay personas en la base de datos!");
    }

    
}
