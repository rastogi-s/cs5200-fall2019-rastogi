package edu.northeastern.cs5200.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * The Class Enrollment.
 */
@Entity
public class Enrollment implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/** The enrolled student. */
	@ManyToOne
	private Student enrolledStudent;

	/** The enrolled section. */
	@ManyToOne
	private Section enrolledSection;

	/** The grade. */
	private int grade;

	/** The feedback. */
	private String feedback;

	/**
	 * Gets the enrolled student.
	 *
	 * @return the enrolled student
	 */
	public Student getEnrolledStudent() {
		return enrolledStudent;
	}

	/**
	 * Sets the enrolled student.
	 *
	 * @param enrolledStudent the new enrolled student
	 */
	public void setEnrolledStudent(Student enrolledStudent) {
		this.enrolledStudent = enrolledStudent;
	}

	/**
	 * Gets the enrolled section.
	 *
	 * @return the enrolled section
	 */
	public Section getEnrolledSection() {
		return enrolledSection;
	}

	/**
	 * Sets the enrolled section.
	 *
	 * @param erolledSection the new enrolled section
	 */
	public void setEnrolledSection(Section erolledSection) {
		this.enrolledSection = erolledSection;
	}

	/**
	 * Gets the grade.
	 *
	 * @return the grade
	 */
	public int getGrade() {
		return grade;
	}

	/**
	 * Sets the grade.
	 *
	 * @param grade the new grade
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}

	/**
	 * Gets the feedback.
	 *
	 * @return the feedback
	 */
	public String getFeedback() {
		return feedback;
	}

	/**
	 * Sets the feedback.
	 *
	 * @param feedback the new feedback
	 */
	public void setFeedback(String feedback) {
		this.feedback = feedback;
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
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enrolledSection == null) ? 0 : enrolledSection.hashCode());
		result = prime * result + ((enrolledStudent == null) ? 0 : enrolledStudent.hashCode());
		result = prime * result + ((feedback == null) ? 0 : feedback.hashCode());
		result = prime * result + grade;
		result = prime * result + id;
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
		Enrollment other = (Enrollment) obj;
		if (enrolledSection == null) {
			if (other.enrolledSection != null)
				return false;
		} else if (!enrolledSection.equals(other.enrolledSection))
			return false;
		if (enrolledStudent == null) {
			if (other.enrolledStudent != null)
				return false;
		} else if (!enrolledStudent.equals(other.enrolledStudent))
			return false;
		if (feedback == null) {
			if (other.feedback != null)
				return false;
		} else if (!feedback.equals(other.feedback))
			return false;
		if (grade != other.grade)
			return false;
		if (id != other.id)
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
		return "Enrollment [id=" + id + ", enrolledStudent=" + enrolledStudent + ", enrolledSection=" + enrolledSection
				+ ", grade=" + grade + ", feedback=" + feedback + "]";
	}

}
