package com.persona.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.persona.modelo.Persona;
import com.persona.service.IPersonaService;
@Controller
public class PersonaController {
	
	@Autowired
	private IPersonaService service;
	
	@GetMapping("/listar")
	public String listarPersonas(Model model) {
		List<Persona> personas = service.listPersona();
		model.addAttribute("personas",personas);
		return "index";
	}
	
	@GetMapping("/new")
	public String guardarPersona(Model model) {
		model.addAttribute("persona", new Persona());
		return "formagregar";
	}
	
	@PostMapping("/save")
	public String savePersona(Persona persona) {
		service.save(persona);
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editarPersona(@PathVariable int id, Model model) {
		Optional<Persona> persona = service.getPersonaById(id);
		model.addAttribute("persona", persona);
		return "formeditar";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarPersona(@PathVariable int id) {
		service.delete(id);
		return "redirect:/listar";
	}
}
