package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Topic;

/**
 * The Interface TopicRepository.
 */
public interface TopicRepository extends CrudRepository<Topic, Integer> {
}
