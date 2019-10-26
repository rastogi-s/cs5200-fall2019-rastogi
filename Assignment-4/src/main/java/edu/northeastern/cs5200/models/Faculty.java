package edu.northeastern.cs5200.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * The Class Faculty.
 */
@Entity
public class Faculty extends Person {

	/** The office. */
	private String office;

	/** The tenured. */
	private boolean tenured;

	/** The authored courses. */
	@OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
	private List<Course> authoredCourses;

	/**
	 * Instantiates a new faculty.
	 */
	public Faculty() {
		super();
	}

	/**
	 * Instantiates a new faculty.
	 *
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @param username  the username
	 * @param password  the password
	 */
	public Faculty(String firstName, String lastName, String username, String password) {
		super(firstName, lastName, username, password);
	}

	/**
	 * Instantiates a new faculty.
	 *
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @param username  the username
	 * @param password  the password
	 * @param office    the office
	 * @param tenured   the tenured
	 */
	public Faculty(String firstName, String lastName, String username, String password, String office,
			boolean tenured) {
		super(firstName, lastName, username, password);
		this.office = office;
		this.tenured = tenured;
	}

	/**
	 * Gets the office.
	 *
	 * @return the office
	 */
	public String getOffice() {
		return office;
	}

	/**
	 * Sets the office.
	 *
	 * @param office the new office
	 */
	public void setOffice(String office) {
		this.office = office;
	}

	/**
	 * Checks if is tenured.
	 *
	 * @return true, if is tenured
	 */
	public boolean isTenured() {
		return tenured;
	}

	/**
	 * Sets the tenured.
	 *
	 * @param tenured the new tenured
	 */
	public void setTenured(boolean tenured) {
		this.tenured = tenured;
	}

	/**
	 * Gets the authored courses.
	 *
	 * @return the authored courses
	 */
	public List<Course> getAuthoredCourses() {
		return authoredCourses;
	}

	/**
	 * Sets the authored courses.
	 *
	 * @param courses the new authored courses
	 */
	public void setAuthoredCourses(List<Course> courses) {
		this.authoredCourses = courses;
	}

	/**
	 * Adds the authored course.
	 *
	 * @param course the course
	 */
	public void addAuthoredCourse(Course course) {
		if (authoredCourses == null)
			authoredCourses = new ArrayList<>();

		this.authoredCourses.add(course);
		if (course.getAuthor() != this)
			course.setAuthor(this);

	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((office == null) ? 0 : office.hashCode());
		result = prime * result + (tenured ? 1231 : 1237);
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faculty other = (Faculty) obj;
		if (office == null) {
			if (other.office != null)
				return false;
		} else if (!office.equals(other.office))
			return false;
		if (tenured != other.tenured)
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
		return "Faculty [getOffice()=" + getOffice() + ", isTenured()=" + isTenured() + ", hashCode()=" + hashCode()
				+ ", getId()=" + getId() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword() + "]";
	}

}
