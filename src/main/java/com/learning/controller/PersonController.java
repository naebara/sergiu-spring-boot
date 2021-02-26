package com.learning.controller;

import com.learning.dto.CarDto;
import com.learning.dto.PersonDto;
import com.learning.mapper.CarMapper;
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
    @Autowired
    private CarMapper carMapper;

    @GetMapping("/getAllPersons")
    public List<PersonDto> getAllPerson() {
        List<Person> persons = personService.getAllPersons();
        return persons.stream()
                .map(this::mapToPersonDto)
                .collect(Collectors.toList());
    }

    private PersonDto mapToPersonDto(Person person) {
        PersonDto personDto = personMapper.mapToDto(person);
        List<CarDto> carDtos = getMappedDtoCars(person);
        personDto.setCars(carDtos);
        return personDto;
    }

    private List<CarDto> getMappedDtoCars(Person person) {
        return person.getCars()
                .stream()
                .map(carMapper::mapToDto)
                .collect(Collectors.toList());
    }


    @GetMapping("/getPersonById/{someId}")
    public PersonDto getPersonById(@PathVariable(value = "someId") Integer personId) {
        logger.info("Get person by id called");

        Person personById = personService.findPersonById(personId);

        logger.info("Get person by id finished successfuly");
        return mapToPersonDto(personById);
    }

    @PutMapping("/update")
    public PersonDto updatePerson(@RequestBody @Valid Person person) {
        return mapToPersonDto(personService.updatePerson(person));

    }

    @GetMapping("/getPersonByIdAndName/{id}/{name}")
    public PersonDto getByIdAndName(@PathVariable Integer id, @PathVariable String name) {
        Person person = personService.findByFirstNameAndId(name, id);
        return personMapper.mapToDto(person);
    }

    @DeleteMapping("/remove/{id}")
    public PersonDto removePersonById(@PathVariable Integer id) {
        return personMapper.mapToDto(personService.removePersonById(id));
    }

    @PostMapping("/add")
    public PersonDto createPerson(@RequestBody @Valid Person person) {
        logger.info("Trecut prin controller");
        Person p = personService.createPerson(person);
        List<CarDto> carDtos = p.getCars().stream()
                .map(car -> carMapper.mapToDto(car))
                .collect(Collectors.toList());
        PersonDto personDto = personMapper.mapToDto(p);
        personDto.setCars(carDtos);

        return personDto;
    }
}