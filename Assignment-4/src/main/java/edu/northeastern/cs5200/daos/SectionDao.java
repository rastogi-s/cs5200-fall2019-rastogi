package edu.northeastern.cs5200.daos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.repositories.SectionRepository;

/**
 * The Class SectionDao.
 */
@Repository
public class SectionDao {

	/** The section repository. */
	@Autowired
	private SectionRepository sectionRepository;

	/**
	 * Creates the section.
	 *
	 * @param section the section
	 * @return the section
	 */
	public Section createSection(Section section) {
		return sectionRepository.save(section);
	}

	/**
	 * Find all sections.
	 *
	 * @return the list
	 */
	public List<Section> findAllSections() {
		Iterable<Section> iter = sectionRepository.findAll();
		List<Section> listOfSection = new ArrayList<>();
		for (Section section : iter) {
			listOfSection.add(section);
		}

		return listOfSection;
	}

	/**
	 * Find section for course.
	 *
	 * @param course the course
	 * @return the list
	 */
	public List<Section> findSectionForCourse(Course course) {
		return sectionRepository.findSectionsByCourseId(course.getId());
	}

}
