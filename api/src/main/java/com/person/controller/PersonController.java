package com.person.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.person.entity.Person;
import com.person.service.PersonService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@RestController
@RequestMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService service;

    @PostMapping
    public ResponseEntity<Person> save(@Valid @RequestBody(required = true) Person person) {

        logger.info("save()");

        person.setId(null);
        person = service.save(person);

        final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(person.getId())
                .toUri();
        return ResponseEntity.created(uri).body(person);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable(name = "id", required = true) Long id,
            @Valid @RequestBody(required = true) Person person) {

        logger.info("update()");

        person.setId(id);
        person = service.update(id, person);
        return ResponseEntity.ok(person);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> one(@PathVariable(name = "id", required = true) Long id) {

        logger.info("one()");
        return ResponseEntity.ok(service.findById(id));

    }

    @GetMapping
    public ResponseEntity<List<Person>> all() {

        logger.info("all()");
        return ResponseEntity.ok(service.findAll());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(name = "id", required = true) Long id) {

        logger.info("delete()");
        service.delete(id);
    }

}