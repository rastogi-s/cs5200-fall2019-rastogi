package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Question;

/**
 * The Interface QuestionRepository.
 */
public interface QuestionRepository extends CrudRepository<Question, Integer> {
}
