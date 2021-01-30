package com.learning.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.learning.enums.Gender;

import java.time.LocalDate;

public class Person {

    static int idCount = 1;

    int id;
    String firstName;
    String lastName;
    Gender gender;
    int age;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate dateOfBirth;
    String email;

    public Person() {
    }

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
        System.out.println(idCount);
        return idCount++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                '}';
    }
}
