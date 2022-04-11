package com.equifax.backend.apirest.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.equifax.backend.apirest.models.entity.Person;
import com.equifax.backend.apirest.models.services.IPersonService;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class PersonRestController {

	@Autowired
	private IPersonService personService;
	
	@GetMapping("/persons")
	public List<Person> index(){
		return personService.findAll();
	}
	
	@GetMapping("/persons/{id}")
	public Person show(@PathVariable Long id) {
		return this.personService.findById(id);
	}

	@PostMapping("/persons")
	@ResponseStatus(HttpStatus.CREATED)
	public Person create(@RequestBody Person person) {
		person.setBirthDt(new Date());
		this.personService.save(person);
		return person;
	}

	@PutMapping("/persons/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Person update(@RequestBody Person person, @PathVariable Long id) {
		Person currentPerson = this.personService.findById(id);
		currentPerson.setName(person.getName());
		currentPerson.setSureName(person.getSureName());
		currentPerson.setBirthDt(person.getBirthDt());
		currentPerson.setEmail(person.getEmail());
		currentPerson.setPhoneNbr(person.getPhoneNbr());
		
		this.personService.save(currentPerson);
		return currentPerson;
	}

	@DeleteMapping("/persons/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Person currentPerson = this.personService.findById(id);
		this.personService.delete(currentPerson);
	}
}
