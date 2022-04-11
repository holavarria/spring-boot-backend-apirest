package com.equifax.backend.apirest.models.services;

import java.util.List;

import com.equifax.backend.apirest.models.entity.Person;

public interface IPersonService {

	public List<Person> findAll();
	public void save(Person person);
	public Person findById(Long id);
	public void delete(Person person);
}
