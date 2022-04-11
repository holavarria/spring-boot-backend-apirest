package com.equifax.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.equifax.backend.apirest.models.dao.IPersonDAO;
import com.equifax.backend.apirest.models.entity.Person;

@Service
public class PersonServiceImpl implements IPersonService{

	@Autowired
	private IPersonDAO personDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Person> findAll() {
		return (List<Person>) personDAO.findAll();
	}
	
	@Override
	@Transactional
	public void save(Person person) {
		personDAO.save(person);
	}

	@Override
	@Transactional(readOnly = true)
	public Person findById(Long id) {
		return personDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Person person) {
		personDAO.delete(person);
		
	}


}
