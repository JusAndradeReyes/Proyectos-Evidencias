package com.persona.service;
import java.util.List;
import java.util.Optional;
import com.persona.modelo.Persona;
public interface IPersonaService {
	public int save(Persona persona);
	public List<Persona> listPersona();
	public void delete(int id);
	public Optional<Persona> getPersonaById(int id);
}
