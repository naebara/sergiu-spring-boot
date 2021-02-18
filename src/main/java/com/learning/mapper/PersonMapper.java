package com.learning.mapper;

import com.learning.dto.PersonDto;
import com.learning.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {


    public PersonDto mapToDto(Person person) {
        return new PersonDto(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(),
                person.getAge(), person.getDateOfBirth(), person.getEmail());
    }
}
