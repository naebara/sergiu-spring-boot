package com.learning.controller;

import com.learning.dto.PersonDto;
import com.learning.mapper.PersonMapper;
import com.learning.model.Person;
import com.learning.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;
    private Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonMapper personMapper;

    @GetMapping("/getAllPersons")
    public List<PersonDto> getAllPerson() {
        List<Person> persons = personService.getAllPersons();
//        List<PersonDto> l = new ArrayList<>();
//        for (int i = 0; i < persons.size(); i++) {
//            l.add(personMapper.mapToDto(persons.get(i)));
//        }
//        return l;
//
        return persons.stream()
                .map(personMapper::mapToDto)
                .collect(Collectors.toList());
    }


    @GetMapping("/getPersonById/{someId}")
    public Person getPersonById(@PathVariable(value = "someId") Integer personId) {
        logger.info("Get person by id called");

        Person personById = personService.findPersonById(personId);

        logger.info("Get person by id finished successfuly");
        return personById;
    }

    @PutMapping("/update")
    public Person updatePerson(@RequestBody @Valid Person person) {
        return personService.updatePerson(person);

    }

    @GetMapping("/getPersonByIdAndName/{id}/{name}")
    public PersonDto getByIdAndName(@PathVariable Integer id, @PathVariable String name) {
        Person person = personService.findByFirstNameAndId(name, id);
        return personMapper.mapToDto(person);
    }

    @DeleteMapping("/remove/{id}")
    public Person removePersonById(@PathVariable Integer id) {
        return personService.removePersonById(id);
    }

    @PostMapping("/add")
    public Person createPerson(@RequestBody @Valid Person person) {
        logger.info("Trecut prin controller");
        return personService.createPerson(person);
    }
}