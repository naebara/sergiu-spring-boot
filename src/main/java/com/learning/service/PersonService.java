package com.learning.service;

import com.learning.exeptions.ResourceNotFoundException;
import com.learning.model.Event;
import com.learning.model.Person;
import com.learning.repo.CarRepository;
import com.learning.repo.EventRepository;
import com.learning.repo.PersonRepository;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CarRepository carRepository;

    private Logger logger = LoggerFactory.getLogger(PersonService.class);

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person createPerson(Person person) {
        
        Event e = new Event();
        e.setPrice(36);
        e.setEventName("Paradise Smoke");
        e.setLocation("Insulele Plouate");
        e.setRank(3);
        eventRepository.save(e);

        person.getEvents().add(e);

        Person p = personRepository.save(person);
        return person;
    }

    public Person findPersonById(int personId) {
        return personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + personId + " not found!"));
    }

    public Person findByFirstNameAndId(String name, int id) {
        return personRepository.findByFirstNameAndId(name, id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " and First Name " + name + " not found!"));
    }

    public Person removePersonById(Integer id) {
        Person person = findPersonById(id);
        personRepository.delete(person);
        return person;
    }



    public Person updatePerson(Person newPerson) {
        Person oldPerson = findPersonById(newPerson.getId());
        updatePersonFields(newPerson, oldPerson);
        personRepository.save(oldPerson);
        return oldPerson;
    }

    public void updatePersonFields(Person newPerson, Person oldPerson) {
        oldPerson.setDateOfBirth(newPerson.getDateOfBirth());
        oldPerson.setAge(newPerson.getAge());
        oldPerson.setEmail(newPerson.getEmail());
        oldPerson.setFirstName(newPerson.getFirstName());
        oldPerson.setLastName(newPerson.getLastName());
        oldPerson.setGender(newPerson.getGender());
    }
}
