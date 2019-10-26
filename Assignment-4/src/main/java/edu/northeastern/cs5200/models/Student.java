package edu.northeastern.cs5200.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * The Class Student.
 */
@Entity
public class Student extends Person {

	/** The grad year. */
	@Column(name = "grad_year")
	private int gradYear;

	/** The scholarship. */
	private long scholarship;

	/** The answers. */
	@OneToMany
	private List<Answer> answers;

	/** The enrolled students. */
	@OneToMany(mappedBy = "enrolledStudent")
	private List<Enrollment> enrolledStudents;

	/**
	 * Instantiates a new student.
	 */
	public Student() {
		super();
	}

	/**
	 * Instantiates a new student.
	 *
	 * @param firstName   the first name
	 * @param lastName    the last name
	 * @param username    the username
	 * @param password    the password
	 * @param gradYear    the grad year
	 * @param scholarship the scholarship
	 */
	public Student(String firstName, String lastName, String username, String password, int gradYear,
			long scholarship) {
		super(firstName, lastName, username, password);
		this.gradYear = gradYear;
		this.scholarship = scholarship;
	}

	/**
	 * Gets the grad year.
	 *
	 * @return the grad year
	 */
	public int getGradYear() {
		return gradYear;
	}

	/**
	 * Sets the grad year.
	 *
	 * @param gradYear the new grad year
	 */
	public void setGradYear(int gradYear) {
		this.gradYear = gradYear;
	}

	/**
	 * Gets the scholarship.
	 *
	 * @return the scholarship
	 */
	public long getScholarship() {
		return scholarship;
	}

	/**
	 * Sets the scholarship.
	 *
	 * @param scholarship the new scholarship
	 */
	public void setScholarship(long scholarship) {
		this.scholarship = scholarship;
	}

	/**
	 * Gets the answers.
	 *
	 * @return the answers
	 */
	public List<Answer> getAnswers() {
		return answers;
	}

	/**
	 * Sets the answers.
	 *
	 * @param answers the new answers
	 */
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	/**
	 * Adds the answer.
	 *
	 * @param answer the answer
	 */
	public void addAnswer(Answer answer) {
		if (answers == null)
			answers = new ArrayList<>();
		this.answers.add(answer);
		if (answer.getStudent() != this)
			answer.setStudent(this);
	}

	/**
	 * Gets the enrolled students.
	 *
	 * @return the enrolled students
	 */
	public List<Enrollment> getEnrolledStudents() {
		return enrolledStudents;
	}

	/**
	 * Sets the enrolled students.
	 *
	 * @param enrolledStudents the new enrolled students
	 */
	public void setEnrolledStudents(List<Enrollment> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	/**
	 * Enroll student.
	 *
	 * @param enrollment the enrollment
	 */
	public void enrollStudent(Enrollment enrollment) {
		if (enrolledStudents == null)
			enrolledStudents = new ArrayList<>();
		enrolledStudents.add(enrollment);
		if (enrollment.getEnrolledStudent() != this)
			enrollment.setEnrolledStudent(this);
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
		result = prime * result + gradYear;
		result = prime * result + (int) (scholarship ^ (scholarship >>> 32));
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
		Student other = (Student) obj;
		if (gradYear != other.gradYear)
			return false;
		if (scholarship != other.scholarship)
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
		return "Student [getGradYear()=" + getGradYear() + ", getScholarship()=" + getScholarship() + ", hashCode()="
				+ hashCode() + ", getId()=" + getId() + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword() + "]";
	}

}
