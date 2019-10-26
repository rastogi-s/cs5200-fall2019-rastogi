package edu.northeastern.cs5200.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * The Class Section.
 */
@Entity
public class Section {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/** The title. */
	private String title;

	/** The seats. */
	private int seats;

	/** The course. */
	@ManyToOne
	private Course course;

	/** The enrolled sections. */
	@OneToMany(mappedBy = "enrolledSection")
	private List<Enrollment> enrolledSections;

	/**
	 * Instantiates a new section.
	 */
	public Section() {
		super();
	}

	/**
	 * Instantiates a new section.
	 *
	 * @param title  the title
	 * @param seats  the seats
	 * @param course the course
	 */
	public Section(String title, int seats, Course course) {
		super();
		this.title = title;
		this.seats = seats;
		this.course = course;
	}

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
	 * Gets the seats.
	 *
	 * @return the seats
	 */
	public int getSeats() {
		return seats;
	}

	/**
	 * Sets the seats.
	 *
	 * @param seats the new seats
	 */
	public void setSeats(int seats) {
		this.seats = seats;
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
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Sets the course.
	 *
	 * @param course the new course
	 */
	public void setCourse(Course course) {
		this.course = course;

		if (course.getSections() == null) {
			course.addSection(this);
		} else if (!course.getSections().contains(this)) {
			course.getSections().add(this);
		}
	}

	/**
	 * Gets the enrolled sections.
	 *
	 * @return the enrolled sections
	 */
	public List<Enrollment> getEnrolledSections() {
		return enrolledSections;
	}

	/**
	 * Sets the enrolled sections.
	 *
	 * @param enrolledSections the new enrolled sections
	 */
	public void setEnrolledSections(List<Enrollment> enrolledSections) {
		this.enrolledSections = enrolledSections;
	}

	/**
	 * Enroll section.
	 *
	 * @param enrollment the enrollment
	 */
	public void enrollSection(Enrollment enrollment) {
		if (enrolledSections == null)
			enrolledSections = new ArrayList<>();
		enrolledSections.add(enrollment);
		if (enrollment.getEnrolledSection() != this)
			enrollment.setEnrolledSection(this);

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
		result = prime * result + ((enrolledSections == null) ? 0 : enrolledSections.hashCode());
		result = prime * result + id;
		result = prime * result + seats;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Section other = (Section) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (enrolledSections == null) {
			if (other.enrolledSections != null)
				return false;
		} else if (!enrolledSections.equals(other.enrolledSections))
			return false;
		if (id != other.id)
			return false;
		if (seats != other.seats)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
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
		return "Section [id=" + id + ", title=" + title + ", seats=" + seats + ", course=" + course
				+ ", enrolledSections=" + enrolledSections + "]";
	}

}
