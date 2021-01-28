package com.learning.controller;

import com.learning.model.Person;
import com.learning.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;
    private Logger logger = LoggerFactory.getLogger(PersonController.class);


    @GetMapping("/getAllPersons")
    public List<Person> getAllPerson() {
        return personService.findAll();
    }

    @GetMapping("/getPersonById/{someId}")
    public Person getPersonById(@PathVariable(value = "someId") Integer personId) {
        logger.info("Get person by id called");
        
        Person personById = personService.findPersonById(personId); // error

        logger.info("Get person by id finished successfuly");
        return personById;
    }

    @GetMapping("/getPersonByIdAndName/{id}/{name}")
    public Person getByIdAndName(@PathVariable Integer id, @PathVariable String name) {
        return personService.findByNameAndId(name, id);
    }


}
