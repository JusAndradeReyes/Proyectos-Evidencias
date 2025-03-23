package com.planets.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.planets.modelo.Planet;
import com.planets.service.PlanetsService;
@RestController
public class PlanetController {
	@Autowired
	private PlanetsService planetsService;
	
	//ENDPOINT GET: http://localhost:7676/swapi.dev/api/planet/id
	@GetMapping(value = "/swapi.dev/api/planet/{id}")
	public Planet getPlanetById(@PathVariable int id) {
		return planetsService.findByIdPlanetService(id);
	}
}
