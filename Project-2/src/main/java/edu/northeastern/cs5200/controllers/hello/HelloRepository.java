package edu.northeastern.cs5200.controllers.hello;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Interface HelloRepository.
 */
public interface HelloRepository extends JpaRepository<HelloObject, Integer> {

}
