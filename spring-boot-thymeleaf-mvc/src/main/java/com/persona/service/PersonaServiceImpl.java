package com.persona.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persona.dao.IPersonaDao;
import com.persona.modelo.Persona;
@Service
public class PersonaServiceImpl implements IPersonaService {
	
	@Autowired
	private IPersonaDao dao;
	
	@Override
	public int save(Persona persona) {
		int result = 0;
		Persona p = dao.save(persona);
		if (!p.equals(null)) {
			result = 1;
		}
		return result;
	}

	@Override
	public List<Persona> listPersona() {
		return (List<Persona>) dao.findAll();
	}

	@Override
	public void delete(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Persona> getPersonaById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

}
