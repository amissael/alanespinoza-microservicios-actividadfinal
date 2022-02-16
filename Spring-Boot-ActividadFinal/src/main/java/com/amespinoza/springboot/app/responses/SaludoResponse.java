package com.amespinoza.springboot.app.responses;

import com.amespinoza.springboot.app.entities.Saludo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaludoResponse {
	
	private Long id;
	private String tipo;
	private String saludo;
	
	public SaludoResponse(Saludo saludar) {
		this.id = saludar.getId();
		this.tipo = saludar.getTipo();
		this.saludo = saludar.getSaludo(); 
	}

}
