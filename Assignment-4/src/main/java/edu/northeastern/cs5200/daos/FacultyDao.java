package edu.northeastern.cs5200.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Faculty;
import edu.northeastern.cs5200.repositories.FacultyRepository;

/**
 * The Class FacultyDao.
 */
@Repository
public class FacultyDao {

	/** The faculty repository. */
	@Autowired
	private FacultyRepository facultyRepository;

	/**
	 * Creates the faculty.
	 *
	 * @param faculty the faculty
	 * @return the faculty
	 */
	public Faculty createFaculty(Faculty faculty) {
		return facultyRepository.save(faculty);
	}

	/**
	 * Find all faculty.
	 *
	 * @return the list
	 */
	public List<Faculty> findAllFaculty() {
		Iterable<Faculty> iter = facultyRepository.findAll();
		List<Faculty> listOfFaculty = new ArrayList<>();
		for (Faculty faculty : iter) {
			listOfFaculty.add(faculty);
		}

		return listOfFaculty;
	}

	/**
	 * Find courses for author.
	 *
	 * @param faculty the faculty
	 * @return the list
	 */
	public List<Course> findCoursesForAuthor(Faculty faculty) {
		Optional<Faculty> opt = facultyRepository.findById(faculty.getId());
		if (opt.isPresent()) {
			return opt.get().getAuthoredCourses();
		}

		return null;
	}

}
