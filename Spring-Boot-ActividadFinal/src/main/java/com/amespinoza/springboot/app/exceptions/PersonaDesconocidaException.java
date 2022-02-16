package com.amespinoza.springboot.app.exceptions;



public class PersonaDesconocidaException extends RuntimeException {
	
	public PersonaDesconocidaException() {
		super("El nombre de persona introducido no existe en la base de datos!");
	}
	
	
}
