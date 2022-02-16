package com.amespinoza.springboot.app.responses;

import java.util.List;

import javax.persistence.Transient;

import com.amespinoza.springboot.app.entities.Persona;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaResponseConSaludo {

	private String saludo;

	private Long id;

	private String nombre;

	private Integer edad;

	private String nombreEmpresa;

	private String direccionEmpresa;

	public PersonaResponseConSaludo(Persona persona) {
		this.saludo = persona.getSaludo();
		this.id = persona.getId();
		this.nombre = persona.getNombre();
		this.edad = persona.getEdad();
		this.nombreEmpresa = persona.getEmpresa().getNombreEmpresa();
		this.direccionEmpresa = persona.getEmpresa().getDireccion();
	}

}
