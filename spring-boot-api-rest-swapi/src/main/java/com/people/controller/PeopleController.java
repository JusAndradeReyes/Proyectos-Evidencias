package com.people.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.people.modelo.People;
import com.people.service.PeopleService;
@RestController
public class PeopleController {
	
	@Autowired
	private PeopleService peopleService;
	
	//ENDPOINT GET: http://localhost:7676/swapi.dev/api/people/id
	@GetMapping(value = "/swapi.dev/api/people/{id}")
	public People getPeopleById(@PathVariable int id) {
		return peopleService.findByIdPeopleService(id);
	}
}
