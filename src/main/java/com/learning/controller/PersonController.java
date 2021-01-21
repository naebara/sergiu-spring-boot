package com.learning.controller;

import com.learning.enums.Gender;
import com.learning.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/person")
public class PersonController {

    List<Person> personList = findAllPersons();
    Logger logger = LoggerFactory.getLogger(PersonController.class);

    @GetMapping("/getPerson")
    public Person getPerson(){
        return personList.get(0);
    }

    @GetMapping("/getAllPersons")
    public List<Person> getAllPerson(){
        return personList;
    }

    @GetMapping("/getPersonById/{someId}")
    public Person getPersonById(@PathVariable(value = "someId") Integer personId) throws Exception {
        // Java 8 Streams API
        // Java 8 Optionals

        return personList.stream()
                .filter(person -> person.getId() == personId)
                .findFirst()
                .orElseThrow(() -> new Exception("User with id " + personId + " not found!"));
    }

    @GetMapping("/getPersonByIdAndName/{id}/{name}")
    public Person getByIdAndName(@PathVariable Integer id, @PathVariable String name) throws Exception {
        return personList.stream()
                .filter(person -> person.getId() == id && person.getFirstName().equals(name))
                .findFirst()
                .orElseThrow(() -> new Exception("Person with id : " + id + " and name: " + name + " not found!"));
    }

    List<Person> findAllPersons(){
        return Arrays.asList(
                new Person("John", "Doe",Gender.MALE, 23, LocalDate.of(1998, Month.MARCH, 5),"john.doe@gmail.com"),
                new Person( "Mary", "Misk",Gender.FEMALE, 67, LocalDate.of(1954, Month.JANUARY, 8),"john.doe@gmail.com")
        );
    }

    @GetMapping("/many/{one}/{two}/{three}/{four}/{five}")
    public void show(@PathVariable Map<String, String> pathVariables){
        Map<String, Double> category_salaries = new HashMap<>();
        category_salaries.put("manager", 346346346.36);

        logger.info(String.valueOf(pathVariables));
    }
























}
