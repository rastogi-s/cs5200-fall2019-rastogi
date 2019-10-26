package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Person;

/**
 * The Interface PersonRepository.
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {

}