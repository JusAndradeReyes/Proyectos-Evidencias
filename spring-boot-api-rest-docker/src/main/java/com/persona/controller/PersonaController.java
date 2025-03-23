package com.persona.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.persona.modelo.Persona;
import com.persona.repository.PersonaRepository;
@RestController
public class PersonaController {
	
	@Autowired
	private PersonaRepository personaRepository;
	
	//ENDPOINT: http://localhost:7575/listar
	@GetMapping("listar")
	public List<Persona> listarPersona(){
		List<Persona> personas = (List<Persona>) personaRepository.findAll();
		return personas;
	}
}
