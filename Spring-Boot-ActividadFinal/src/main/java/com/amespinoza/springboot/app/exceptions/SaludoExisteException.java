package com.amespinoza.springboot.app.exceptions;



public class SaludoExisteException extends RuntimeException {
	
	public SaludoExisteException() {
		super("El saludo que ha tratado de introducir ya existe en la base de datos!");
	}
	
	
}
