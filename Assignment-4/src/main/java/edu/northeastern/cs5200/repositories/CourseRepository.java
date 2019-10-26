package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Course;

/**
 * The Interface CourseRepository.
 */
public interface CourseRepository extends CrudRepository<Course, Integer> {
}
