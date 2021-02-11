package com.learning.service;

import com.learning.exeptions.ResourceNotFoundException;
import com.learning.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    List<Person> personList = new ArrayList<>();

    private Logger logger = LoggerFactory.getLogger(PersonService.class);

    public List<Person> findAll() {
        return this.personList;
    }

    public Person createPerson(Person person) {
        this.personList.add(person);
        return personList.get(personList.size() - 1);
    }

    public Person findPersonById(int personId) {
        return personList.stream()
                .filter(person -> person.getId() == personId)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + personId + " not found!"));
    }

    public Person findByNameAndId(String name, int id) {
        return personList.stream()
                .filter(person -> person.getId() == id && person.getFirstName().equals(name))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Person with id : " + id + " and name: " + name + " not found!"));
    }

    public Person removePersonById(Integer id) {
        Person removedPerson = this.personList.stream().filter(p -> p.getId() == id).findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Person with id " + id + " not found"));

        this.personList = this.personList.stream().filter(p -> p.getId() != id)
                .collect(Collectors.toList());
        return removedPerson;

    }
}
