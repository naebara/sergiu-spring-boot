package com.learning.controller;

import com.learning.enums.Gender;
import com.learning.model.Person;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rp")
public class PersonControllerRP {

    List<Person> personList = findAllPersons();

    @GetMapping("/getById")
    public void show( @RequestParam(name = "id", required = false) Integer personId){
        if(personId != null){
            System.out.println(personId);
        }else{
            System.out.println(999);
        }
    }

    @GetMapping("/getByIdSecond")
    public void show1(@RequestParam(defaultValue = "999") String id){
        System.out.println(id);
    }

    @GetMapping("/getByIds")
    public void show2(@RequestParam List<String> ids){
        System.out.println(ids);
    }


    List<Person> findAllPersons(){
        return Arrays.asList(
                new Person("John", "Doe", Gender.MALE, 23, LocalDate.of(1998, Month.MARCH, 5),"john.doe@gmail.com"),
                new Person( "Mary", "Misk",Gender.FEMALE, 67, LocalDate.of(1954, Month.JANUARY, 8),"john.doe@gmail.com")
        );
    }
}
