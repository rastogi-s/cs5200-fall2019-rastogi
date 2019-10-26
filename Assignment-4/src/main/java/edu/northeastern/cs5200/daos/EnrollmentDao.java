package edu.northeastern.cs5200.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.northeastern.cs5200.models.Enrollment;
import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.models.Student;
import edu.northeastern.cs5200.repositories.EnrollmentRepository;
import edu.northeastern.cs5200.repositories.SectionRepository;

/**
 * The Class EnrollmentDao.
 */
@Repository
public class EnrollmentDao {

	/** The section repository. */
	@Autowired
	private SectionRepository sectionRepository;

	/** The enrollment repository. */
	@Autowired
	private EnrollmentRepository enrollmentRepository;

	/**
	 * Enroll student in section.
	 *
	 * @param student the student
	 * @param section the section
	 * @return the boolean
	 */
	public Boolean enrollStudentInSection(Student student, Section section) {

		if (section.getSeats() > 0) {
			section.setSeats(section.getSeats() - 1);
			sectionRepository.save(section);
			Enrollment enrollment = new Enrollment();
			enrollment.setEnrolledSection(section);
			enrollment.setEnrolledStudent(student);
			enrollmentRepository.save(enrollment);
			return true;
		}
		return false;
	}

	/**
	 * Find students in section.
	 *
	 * @param section the section
	 * @return the list
	 */
	public List<Student> findStudentsInSection(Section section) {
		return enrollmentRepository.findStudentsBySectionId(section.getId());
	}

	/**
	 * Find sections for student.
	 *
	 * @param student the student
	 * @return the list
	 */
	public List<Section> findSectionsForStudent(Student student) {
		return enrollmentRepository.findSectionsByStudentId(student.getId());
	}

}
