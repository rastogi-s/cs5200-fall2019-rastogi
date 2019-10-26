package edu.northeastern.cs5200.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * The Class Answer.
 */
@Entity
public class Answer {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/** The student. */
	@ManyToOne
	private Student student;

	/** The question. */
	@ManyToOne
	private Question question;

	/** The true false answer. */
	@Column(name = "true_false_answer")
	private boolean trueFalseAnswer;

	/** The multiple choice answer. */
	@Column(name = "multiple_choice_answer")
	private int multipleChoiceAnswer;

	/**
	 * Gets the student.
	 *
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * Sets the student.
	 *
	 * @param student the new student
	 */
	public void setStudent(Student student) {
		this.student = student;
		if (student.getAnswers() == null) {
			student.addAnswer(this);
		} else if (!student.getAnswers().contains(this)) {
			student.getAnswers().add(this);
		}
	}

	/**
	 * Gets the question.
	 *
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * Sets the question.
	 *
	 * @param question the new question
	 */
	public void setQuestion(Question question) {
		this.question = question;
		if (question.getAnswers() == null) {
			question.addAnswer(this);
		} else if (!question.getAnswers().contains(this)) {
			question.getAnswers().add(this);
		}
	}

	/**
	 * Checks if is true false answer.
	 *
	 * @return true, if is true false answer
	 */
	public boolean isTrueFalseAnswer() {
		return trueFalseAnswer;
	}

	/**
	 * Sets the true false answer.
	 *
	 * @param trueFalseAnswer the new true false answer
	 */
	public void setTrueFalseAnswer(boolean trueFalseAnswer) {
		this.trueFalseAnswer = trueFalseAnswer;
	}

	/**
	 * Gets the multiple choice answer.
	 *
	 * @return the multiple choice answer
	 */
	public int getMultipleChoiceAnswer() {
		return multipleChoiceAnswer;
	}

	/**
	 * Sets the multiple choice answer.
	 *
	 * @param multipleChoiceAnswer the new multiple choice answer
	 */
	public void setMultipleChoiceAnswer(int multipleChoiceAnswer) {
		this.multipleChoiceAnswer = multipleChoiceAnswer;
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
		result = prime * result + id;
		result = prime * result + multipleChoiceAnswer;
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
		result = prime * result + (trueFalseAnswer ? 1231 : 1237);
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
		Answer other = (Answer) obj;
		if (id != other.id)
			return false;
		if (multipleChoiceAnswer != other.multipleChoiceAnswer)
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		if (trueFalseAnswer != other.trueFalseAnswer)
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
		return "Answer [id=" + id + ", student=" + student + ", question=" + question + ", trueFalseAnswer="
				+ trueFalseAnswer + ", multipleChoiceAnswer=" + multipleChoiceAnswer + "]";
	}

}
