package com.learning.service;

import com.learning.enums.Gender;
import com.learning.exeptions.ResourceNotFoundException;
import com.learning.model.Person;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@Service
public class PersonService {

    List<Person> personList = findAllPersons();

    public List<Person> findAll() {
        return this.personList;
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

    private List<Person> findAllPersons() {
        return Arrays.asList(
                new Person("John", "Doe", Gender.MALE, 23, LocalDate.of(1998, Month.MARCH, 5), "john.doe@gmail.com"),
                new Person("Mary", "Misk", Gender.FEMALE, 67, LocalDate.of(1954, Month.JANUARY, 8), "john.doe@gmail.com")
        );
    }

}
