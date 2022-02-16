package com.amespinoza.springboot.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amespinoza.springboot.app.entities.Persona;

@Repository
public interface PersonaRepositorio  extends JpaRepository<Persona,Long>{
	
	List<Persona> findByNombre(String nombre);

}
