package com.persona.dao;
import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.persona.modelo.Persona;

@Repository
public interface IPersonaDao extends CrudRepository<Persona, Serializable>{
	
	/*
	 * NO SE PROGRAMAN LAS CONSULTAS PORQUE YA ESTAN IMPLEMENTADAS EN
	 * CRUD REPOSITORY
	 */
}
