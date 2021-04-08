package com.learning.service;

import com.learning.enums.Gender;
import com.learning.exeptions.ResourceNotFoundException;
import com.learning.model.Person;
import com.learning.repo.PersonRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.AssertTrue;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    @Test
    @DisplayName("Update person attributes")
    public void updatePersonFields_shoudModifyAttributes(){
        Person person = new Person(1, "Nae", "Bara", Gender.MALE, 22, LocalDate.of(1999, Month.FEBRUARY, 13), "naebara@yahoo.com", null, null, null);
        Person updated = new Person(1, "Naty", "Barack", Gender.MALE, 23, LocalDate.of(1999, Month.MARCH, 11), "baranae@yahoo.com", null, null, null);


        personService.updatePersonFields(updated, person);
//        assertEquals("Naty", person.getFirstName());
//        assertEquals(person.getLastName(), "Barack");
//        assertEquals(23, person.getAge());
//        assertEquals("baranae@yahoo.com", person.getEmail());
//        assertEquals(LocalDate.of(1999, Month.MARCH, 11), person.getDateOfBirth());
      
        assertThat(person.getAge()).isEqualTo(23);
        assertThat(person.getEmail()).isEqualTo("baranae@yahoo.com");
    }


    @Test
    @DisplayName("find person by id")
    public void findPersonById_shouldReturnDesiredUser(){
        personService.setPersonRepository(personRepository);

        Person person = new Person();
        person.setId(6);
        person.setFirstName("Nae");
        person.setLastName("Bara");
        person.setAge(22);

        when(personRepository.findById(any())).thenReturn(Optional.of(person));

        Person res = personService.findPersonById(6);

        assertThat(res.getFirstName()).isEqualTo("Nae");
        assertThat(res.getLastName()).isEqualTo("Bara");
        assertThat(res.getAge()).isEqualTo(22);
        assertThat(res.getId()).isEqualTo(6);
    }

    @Test
    @DisplayName("find person by id when user does not exist")
    public void findPersonById_shouldThrowError(){
        PersonService personService = new PersonService();
        personService.setPersonRepository(personRepository);

        when(personRepository.findById(any())).thenReturn(Optional.empty());

        assertThatThrownBy( () -> {
            personService.findPersonById(6);
        } ).isInstanceOf(ResourceNotFoundException.class);

    }

    @Test
    @DisplayName("remove person by id")
    public void removePersonById_shouldReturnDeletedPerson(){
        personService.setPersonRepository(personRepository);

        Person person = new Person();
        person.setId(6);
        person.setFirstName("Nae");
        person.setLastName("Bara");
        person.setAge(22);

        when(personRepository.findById(6)).thenReturn(Optional.of(person));
        Person res = personService.removePersonById(6);

        assertThat(res.getId()).isEqualTo(6);
        verify(personRepository, times(1)).delete(person);
    }


}
