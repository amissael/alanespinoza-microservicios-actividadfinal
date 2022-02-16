package com.amespinoza.springboot.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.amespinoza.springboot.app.entities.Saludo;
import com.amespinoza.springboot.app.requests.CreateSaludoRequest;
import com.amespinoza.springboot.app.responses.SaludoResponse;
import com.amespinoza.springboot.app.services.SaludoService;

@Validated
@RestController
@RequestMapping("/api/saludo")
public class SaludoController {
	
	@Autowired
	SaludoService saludoService;
	
	
	@PostMapping("/crearSaludo")
	public SaludoResponse crearSaludo(@Valid @RequestBody CreateSaludoRequest createSaludoRes ){
	
		Saludo saludo = saludoService.crearSaludo(createSaludoRes);
		
		return new SaludoResponse(saludo);
	}
	
	@GetMapping("/getSaludoPorTipo/{tipoSaludo}")
	public SaludoResponse getSaludoPorTipo(@PathVariable String tipoSaludo) {

		Saludo saludo = saludoService.getByTipo(tipoSaludo);
		return new SaludoResponse(saludo);
	}
	
	

}
