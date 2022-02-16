package com.amespinoza.springboot.app.requests;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSaludoRequest {
	
	@NotBlank(message="Se debe insertar un tipo de saludo valido! (mañana/tarde/noche)")
	private String tipo;
	@NotBlank(message="El campo 'saludo' no debe ir vacío!")
	private String saludo;

}
