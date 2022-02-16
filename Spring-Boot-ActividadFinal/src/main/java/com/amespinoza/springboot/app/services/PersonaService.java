package com.amespinoza.springboot.app.services;

import java.time.LocalDateTime;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.amespinoza.springboot.app.controller.PersonaController;
import com.amespinoza.springboot.app.entities.Empresa;
import com.amespinoza.springboot.app.entities.Persona;
import com.amespinoza.springboot.app.exceptions.PersonaDesconocidaException;
import com.amespinoza.springboot.app.exceptions.PersonaExisteException;
import com.amespinoza.springboot.app.exceptions.SinPersonasException;
import com.amespinoza.springboot.app.repositories.EmpresaRepositorio;
import com.amespinoza.springboot.app.repositories.PersonaRepositorio;
import com.amespinoza.springboot.app.requests.CreatePersonaRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PersonaService {

	Logger logger = LoggerFactory.getLogger(PersonaService.class);

	@Autowired
	PersonaRepositorio personaRepo;

	@Autowired
	EmpresaRepositorio empresaRepo;

	public List<Persona> getTodasPersonas() {

		if (personaRepo.findAll().isEmpty()) {
			logger.error("ERROR - LA BASE DE DATOS NO TIENE PERSONAS");
			throw new SinPersonasException();

		}

		else {
			return personaRepo.findAll();
		}
	}

	public List<Persona> buscarPorNombre(String nombre) {
		if (personaRepo.findByNombre(nombre).isEmpty()) {
			logger.error("ERROR - PERSONA" + nombre + " no existe en la base de datos!");
			throw new PersonaDesconocidaException();
		}
		return personaRepo.findByNombre(nombre);
	}

	public Persona crearPersona(CreatePersonaRequest createPersonaRequest)
			throws JsonMappingException, JsonProcessingException {

		Persona p = new Persona(createPersonaRequest);
		Empresa e = new Empresa();

		if (!personaRepo.findByNombre(p.getNombre()).isEmpty()) {
			logger.error("ERROR - LA PERSONA CON EL NOMBRE " + p.getNombre() + " ya existe en la BD!");
			throw new PersonaExisteException();
		} else {
			e.setNombreEmpresa(createPersonaRequest.getNombreEmpresa());
			e.setDireccion(createPersonaRequest.getDireccionEmpresa());

			e = empresaRepo.save(e);
			p.setEmpresa(e);

			RestTemplate restTemplate = new RestTemplate();
			LocalDateTime ahora = LocalDateTime.now();
			String result;
			ObjectMapper mapper = new ObjectMapper();

			int hora = ahora.getHour();

			if (hora == 5 || hora < 12) {
				String uri = "http://localhost:8080/api/saludo/getSaludoPorTipo/mañana";
				result = restTemplate.getForObject(uri, String.class);

				JsonNode jsonNode = mapper.readTree(result);
				String saludo = jsonNode.get("saludo").asText();

				p.setSaludo(saludo);

			} else if (hora == 12 || hora < 19) {
				String uri = "http://localhost:8080/api/saludo/getSaludoPorTipo/tarde";
				result = restTemplate.getForObject(uri, String.class);

				JsonNode jsonNode = mapper.readTree(result);
				String saludo = jsonNode.get("saludo").asText();

				p.setSaludo(saludo);

			} else if (hora == 19 || hora < 5) {
				String uri = "http://localhost:8080/api/saludo/getSaludoPorTipo/noche";
				result = restTemplate.getForObject(uri, String.class);
				JsonNode jsonNode = mapper.readTree(result);
				String saludo = jsonNode.get("saludo").asText();

				p.setSaludo(saludo);

			}

			p = personaRepo.save(p);

			return p;
		}
	}

}
