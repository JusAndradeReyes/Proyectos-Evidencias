package com.persona.repository;
import org.springframework.data.repository.CrudRepository;
import com.persona.modelo.Persona;
/*
 * CrudRepository<Persona, Serializable> = FORMULARIOS
 * CrudRepository<Persona, Integer>      = MANIPULA SOLO DATOS DE LA URL
 */
public interface PersonaRepository extends CrudRepository<Persona, Integer>{
	
	//NO SE PROGRAMA NINGUN MÉTODO PORQUE YA ESTÁN HECHOS...
}
