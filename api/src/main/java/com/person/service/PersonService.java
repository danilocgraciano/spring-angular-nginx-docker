package com.person.service;

import java.util.List;

import com.person.entity.Person;
import com.person.repository.PersonRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person save(Person p) {
        return repository.save(p);
    }

    public Person update(Long id, Person p) {
        Person person = findById(id);
        BeanUtils.copyProperties(p, person);
        return save(p);
    }

    public Person findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException("Person not found " + id, 1));
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}