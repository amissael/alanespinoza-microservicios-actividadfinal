package com.amespinoza.springboot.app.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.amespinoza.springboot.app.requests.CreatePersonaRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="persona")
public class Persona {
	
	@Transient
	private String saludo;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="edad")
	private Integer edad;
	
	@OneToOne
	@JoinColumn(name="idempresa")
	private Empresa empresa;
	
	
	
	public Persona(CreatePersonaRequest createPersonaRequest){
		this.nombre = createPersonaRequest.getNombre();
		this.edad = createPersonaRequest.getEdad();
	}
	

}
