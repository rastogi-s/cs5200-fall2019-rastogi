package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Lesson;

/**
 * The Interface LessonRepository.
 */
public interface LessonRepository extends CrudRepository<Lesson, Integer> {
}
