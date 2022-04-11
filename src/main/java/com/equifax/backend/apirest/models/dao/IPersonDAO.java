package com.equifax.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.equifax.backend.apirest.models.entity.Person;

public interface IPersonDAO  extends CrudRepository<Person, Long>{

}
