package com.amespinoza.springboot.app.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.amespinoza.springboot.app.entities.Persona;

import com.amespinoza.springboot.app.requests.CreatePersonaRequest;
import com.amespinoza.springboot.app.requests.CreateSaludoRequest;
import com.amespinoza.springboot.app.responses.PersonaResponse;
import com.amespinoza.springboot.app.responses.PersonaResponseConSaludo;
import com.amespinoza.springboot.app.services.PersonaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {
	
	Logger logger = LoggerFactory.getLogger(PersonaController.class);

	@Autowired
	PersonaService personaService;

	@PostMapping("/crearPersona")
	public PersonaResponseConSaludo crearPersona(@Valid @RequestBody CreatePersonaRequest createPersonaReq)
			throws JsonMappingException, JsonProcessingException {
		
		

		Persona persona = personaService.crearPersona(createPersonaReq);

		return new PersonaResponseConSaludo(persona);

	}
	
	@GetMapping("/buscarPorNombre/{nombre}")
	public List<PersonaResponse> buscarPorNombre(@PathVariable String nombre) {
		
		

		List<Persona> listaPersonas = personaService.buscarPorNombre(nombre);
		List<PersonaResponse> listaPersonasResponse = new ArrayList<PersonaResponse>();

		listaPersonas.stream().forEach(p -> {
			listaPersonasResponse.add(new PersonaResponse(p));
		});
		
		return listaPersonasResponse;
	}

	@GetMapping("/getTodasPersonas")
	public List<PersonaResponse> getTodasPersonas() {
		
		
		List<Persona> listaPersonas = personaService.getTodasPersonas();
		List<PersonaResponse> listaPersonasResponse = new ArrayList<PersonaResponse>();

		listaPersonas.stream().forEach(p -> {
			listaPersonasResponse.add(new PersonaResponse(p));
		});
		
		return listaPersonasResponse;

	}

}
