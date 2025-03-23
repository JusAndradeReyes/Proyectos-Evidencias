package com.people.service;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.people.modelo.People;
@Service
public class PeopleServiceImpl implements PeopleService{
	
	@Autowired
	private RestTemplate template;
	
	@Override
	public People findByIdPeopleService(int id) {
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", Integer.toString(id));
		
		//URI DEL RECURSO
		People people = template.getForObject("https://swapi.dev/api/people/{id}", People.class,pathVariables);
		return people;
	}
}
