package com.amespinoza.springboot.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amespinoza.springboot.app.entities.Empresa;



@Repository
public interface EmpresaRepositorio  extends JpaRepository<Empresa,Long> {

}
