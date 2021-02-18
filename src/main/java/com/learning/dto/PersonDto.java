package com.learning.dto;

import com.learning.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    private int id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private int age;
    private LocalDate dateOfBirth;
    private String email;
    private List<CarDto> cars = new ArrayList<>();

    public PersonDto(int id, String firstName, String lastName, Gender gender, int age, LocalDate dateOfBirth, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }
}
