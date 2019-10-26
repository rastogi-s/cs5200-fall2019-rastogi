package edu.northeastern.cs5200.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Enrollment;
import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.models.Student;

/**
 * The Interface EnrollmentRepository.
 */
public interface EnrollmentRepository extends CrudRepository<Enrollment, Integer> {

	/**
	 * Find students by section id.
	 *
	 * @param sectionId the section id
	 * @return the list
	 */
	@Query("SELECT e.enrolledStudent FROM Enrollment e  JOIN e.enrolledSection es WHERE es.id =:sectionId")
	public List<Student> findStudentsBySectionId(@Param("sectionId") int sectionId);

	/**
	 * Find sections by student id.
	 *
	 * @param studentId the student id
	 * @return the list
	 */
	@Query("SELECT e.enrolledSection FROM Enrollment e JOIN e.enrolledStudent es WHERE es.id =:studentId")
	public List<Section> findSectionsByStudentId(int studentId);
}
