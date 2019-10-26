package edu.northeastern.cs5200.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Section;

/**
 * The Interface SectionRepository.
 */
public interface SectionRepository extends CrudRepository<Section, Integer> {

	/**
	 * Find sections by course id.
	 *
	 * @param courseId the course id
	 * @return the list
	 */
	@Query("SELECT s FROM Section s JOIN s.course c WHERE c.id = :courseId")
	public List<Section> findSectionsByCourseId(@Param("courseId") int courseId);
}
