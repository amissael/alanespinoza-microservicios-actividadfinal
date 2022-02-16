package com.amespinoza.springboot.app.requests;

import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePersonaRequest {
	
	
	private String saludo;
	
	@NotBlank(message = "El nombre es requerido!")
	private String nombre;
	
	private Integer edad;
	
	private String nombreEmpresa;
	
	private String direccionEmpresa;
	

}
