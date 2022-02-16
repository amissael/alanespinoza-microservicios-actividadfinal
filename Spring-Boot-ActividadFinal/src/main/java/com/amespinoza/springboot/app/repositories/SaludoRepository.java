package com.amespinoza.springboot.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amespinoza.springboot.app.entities.Saludo;

@Repository
public interface SaludoRepository extends JpaRepository<Saludo,Long> {
	
	Saludo findByTipo(String tipo);
	
	List<Saludo>getByTipo(String tipo);

}
