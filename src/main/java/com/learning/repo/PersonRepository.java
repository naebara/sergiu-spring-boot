package com.learning.repo;

import com.learning.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    Optional<Person> findByFirstNameAndId(String firstName, int id);


}
