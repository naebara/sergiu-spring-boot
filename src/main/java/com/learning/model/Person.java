package com.learning.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.learning.customAnnotations.MyEmail;
import com.learning.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @MyEmail
    private String email;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Car> cars = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driving_license_id")
    private DrivingLicense drivingLicense;

    @ManyToMany
    @JoinTable(
            name = "event_participations",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<Event> events = new ArrayList<>();

}
