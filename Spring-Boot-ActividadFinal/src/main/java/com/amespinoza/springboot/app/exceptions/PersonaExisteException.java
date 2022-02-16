package com.amespinoza.springboot.app.exceptions;

public class PersonaExisteException extends RuntimeException {
	

	public PersonaExisteException() {
       
      super("El nombre de la persona que ha introducido ya existe en la base de datos, intente con otro!");
    }

    
}
