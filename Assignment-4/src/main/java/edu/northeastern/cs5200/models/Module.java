package edu.northeastern.cs5200.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * The Class Module.
 */
@Entity
public class Module {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/** The label. */
	private String label;

	/** The course. */
	@ManyToOne
	private Course course;

	/** The lessons. */
	@OneToMany(mappedBy = "module", fetch = FetchType.EAGER)
	private List<Lesson> lessons;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the label.
	 *
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Sets the label.
	 *
	 * @param label the new label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Gets the course.
	 *
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * Sets the course.
	 *
	 * @param course the new course
	 */
	public void setCourse(Course course) {
		this.course = course;
		if (course.getModules() == null) {
			course.addModule(this);
		} else if (!course.getModules().contains(this)) {
			course.getModules().add(this);
		}
	}

	/**
	 * Gets the lessons.
	 *
	 * @return the lessons
	 */
	public List<Lesson> getLessons() {
		return lessons;
	}

	/**
	 * Sets the lessons.
	 *
	 * @param lessons the new lessons
	 */
	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	/**
	 * Adds the lessons.
	 *
	 * @param lesson the lesson
	 */
	public void addLesson(Lesson lesson) {
		if (lessons == null)
			lessons = new ArrayList<>();
		lessons.add(lesson);
		if (lesson.getModule() != this)
			lesson.setModule(this);
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + id;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((lessons == null) ? 0 : lessons.hashCode());
		return result;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Module other = (Module) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (id != other.id)
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (lessons == null) {
			if (other.lessons != null)
				return false;
		} else if (!lessons.equals(other.lessons))
			return false;
		return true;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Module [id=" + id + ", label=" + label + ", course=" + course + ", lessons=" + lessons + "]";
	}

}
