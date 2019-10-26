package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.TrueFalse;

/**
 * The Interface TrueFalseRepository.
 */
public interface TrueFalseRepository extends CrudRepository<TrueFalse, Integer> {
}
