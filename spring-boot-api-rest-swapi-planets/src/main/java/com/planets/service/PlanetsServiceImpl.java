package com.planets.service;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.planets.modelo.Planet;
@Service
public class PlanetsServiceImpl implements PlanetsService{
	
	@Autowired
	private RestTemplate template;
	
	@Override
	public Planet findByIdPlanetService(int id) {
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", Integer.toString(id));
		
		//URI DEL RECURSO
		Planet planet = template.getForObject("https://swapi.dev/api/planets/{id}", Planet.class,pathVariables);
		return planet;
	}

}
