package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Widget;

/**
 * The Interface WidgetRepository.
 */
public interface WidgetRepository extends CrudRepository<Widget, Integer> {
}
