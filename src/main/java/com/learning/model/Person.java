package com.learning.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.learning.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    static int idCount = 1;

    private int id;

    @NotEmpty(message = "First name must not be empty")
    @Size(min = 3, max = 20, message = "First name must be in range(2,20)")
    private String firstName;

    @NotEmpty(message = "First name must not be empty")
    @Size(min = 3, max = 20, message = "First name must be in range(2,20)")
    private String lastName;

    private Gender gender;

    @Min(value = 1, message = "Age must be greater or equal to 1 ")
    @Max(value = 120, message = "Age must be less or equal to 120")
    private int age;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Past
    private LocalDate dateOfBirth;

    @NotNull(message = "{validation.email.NotNull}")
    private String email;


    public Person(String firstName, String lastName, Gender gender, int age, LocalDate dateOfBirth, String email) {
        this.id = idCount;
        idCount++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public static int generateNextId() {
        return idCount++;
    }
}
