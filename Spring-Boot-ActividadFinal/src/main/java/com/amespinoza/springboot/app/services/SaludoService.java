package com.amespinoza.springboot.app.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amespinoza.springboot.app.entities.Saludo;
import com.amespinoza.springboot.app.exceptions.SaludoExisteException;
import com.amespinoza.springboot.app.exceptions.SaludoNoExisteException;
import com.amespinoza.springboot.app.repositories.SaludoRepository;
import com.amespinoza.springboot.app.requests.CreateSaludoRequest;


@Service
public class SaludoService {

	Logger logger = LoggerFactory.getLogger(SaludoService.class);
	
	@Autowired
	SaludoRepository saludoRepo;

	public Saludo crearSaludo(CreateSaludoRequest createSaludoReq) {
		Saludo saludo = new Saludo(createSaludoReq);
		saludo.getTipo().toLowerCase();
		if (!saludoRepo.getByTipo(saludo.getTipo()).isEmpty()) {
			logger.error("ERROR - EL TIPO " + saludo.getTipo() + " YA EXISTE EN LA BASE DE DATOS!");
			throw new SaludoExisteException();
		} else {

			saludo = saludoRepo.save(saludo);

			return saludo;
		}
	}

	public Saludo getByTipo(String tipoSaludo){ 

		if(saludoRepo.getByTipo(tipoSaludo).isEmpty()) {
			logger.error("ERROR - EL TIPO " + tipoSaludo + " NO EXISTE EN LA BASE DE DATOS!");
			throw new SaludoNoExisteException();
		}
		return saludoRepo.findByTipo(tipoSaludo);
	}

}
