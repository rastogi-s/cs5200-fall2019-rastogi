package edu.northeastern.cs5200.daos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Faculty;
import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.repositories.CourseRepository;

/**
 * The Class CourseDao.
 */
@Repository
public class CourseDao {

	/** The course repository. */
	@Autowired
	private CourseRepository courseRepository;

	/**
	 * Creates the course.
	 *
	 * @param course the course
	 * @return the course
	 */
	public Course createCourse(Course course) {
		return courseRepository.save(course);
	}

	/**
	 * Adds the section to course.
	 *
	 * @param section the section
	 * @param course  the course
	 * @return the course
	 */
	public Course addSectionToCourse(Section section, Course course) {
		course.addSection(section);
		return courseRepository.save(course);
	}

	/**
	 * Sets the author for course.
	 *
	 * @param faculty the faculty
	 * @param course  the course
	 * @return the course
	 */
	public Course setAuthorForCourse(Faculty faculty, Course course) {
		course.setAuthor(faculty);
		return courseRepository.save(course);
	}

	/**
	 * Find all courses.
	 *
	 * @return the list
	 */
	public List<Course> findAllCourses() {
		Iterable<Course> iter = courseRepository.findAll();
		List<Course> listOfCourse = new ArrayList<>();
		for (Course course : iter) {
			listOfCourse.add(course);
		}

		return listOfCourse;
	}
}
