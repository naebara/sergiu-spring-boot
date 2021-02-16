package com.learning.dto;

import com.learning.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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
}
