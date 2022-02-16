package com.amespinoza.springboot.app.exceptions;



public class SaludoNoExisteException extends RuntimeException {
	
	public SaludoNoExisteException() {
		super("El saludo que ha tratado de introducir no existe en la base de datos!");
	}
	
	
}
