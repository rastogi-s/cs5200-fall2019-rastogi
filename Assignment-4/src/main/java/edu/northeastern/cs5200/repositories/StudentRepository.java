package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Student;

/**
 * The Interface StudentRepository.
 */
public interface StudentRepository extends CrudRepository<Student, Integer> {
}
