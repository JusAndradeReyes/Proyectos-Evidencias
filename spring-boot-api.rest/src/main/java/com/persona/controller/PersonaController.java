package com.persona.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.persona.modelo.Persona;
import com.persona.repository.PersonaRepository;
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping({"personas"})
public class PersonaController {
	
	@Autowired
	private PersonaRepository personaRepository;
	
	//ENDPOINT GET: http://localhost:7575/personas/listar
	@GetMapping("listar")
	public List<Persona> listarPersona(){
		List<Persona> personas = (List<Persona>) personaRepository.findAll();
		return personas;
	}
	
	//ENDPOINT GET BY ID: http://localhost:7575/personas/4
	@GetMapping("/{id}")
	public Optional<Persona> getPersonaById(@PathVariable int id){
		return personaRepository.findById(id);
	}
	
	//ENDPOINT POST: http://localhost:7575/personas/{FORMAT JSON}
	@PostMapping
	public Persona agregarPersona(@RequestBody Persona persona){
		return personaRepository.save(persona);
	}
	
	//ENDPOINT PUT: http://localhost:7575/personas/id {FORMAT JSON}
	@PutMapping("/{id}")
	public Persona modificarPersona(@RequestBody Persona persona,@PathVariable int id){
		persona.setId(id);
		return personaRepository.save(persona);
	}
	
	//ENDPOINT DELETE BY ID: http://localhost:7575/personas/id
	@DeleteMapping("/{id}")
	public void eliminarPersonaById(@PathVariable int id){
		personaRepository.deleteById(id);
	}
}
