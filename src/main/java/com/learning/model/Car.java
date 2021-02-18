package com.learning.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String brand;

    private String model;
    private int hp;

    public Car(String audi, String a4, int i) {
        brand = audi;
        model = a4;
        hp = i;
    }

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    private Person seller;
}
