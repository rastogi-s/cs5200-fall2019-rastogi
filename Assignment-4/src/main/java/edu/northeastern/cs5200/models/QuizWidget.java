package edu.northeastern.cs5200.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class QuizWidget.
 */
@Entity
@Table(name = "quiz_widget")
public class QuizWidget extends Widget {

	/** The questions. */
	@OneToMany(mappedBy = "quiz", fetch = FetchType.EAGER)
	private List<Question> questions;

	/**
	 * Gets the questions.
	 *
	 * @return the questions
	 */
	public List<Question> getQuestions() {
		return questions;
	}

	/**
	 * Sets the questions.
	 *
	 * @param questions the new questions
	 */
	public void setQuestions(List<Question> questions) {
		this.questions = questions;

	}

	/**
	 * Adds the question.
	 *
	 * @param question the question
	 */
	public void addQuestion(Question question) {
		if (questions == null)
			questions = new ArrayList<>();
		questions.add(question);
		if (question.getQuiz() != this)
			question.setQuiz(this);
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
		result = prime * result + ((questions == null) ? 0 : questions.hashCode());
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
		QuizWidget other = (QuizWidget) obj;
		if (questions == null) {
			if (other.questions != null)
				return false;
		} else if (!questions.equals(other.questions))
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
		return "QuizWidget [questions=" + questions + ", getId()=" + getId() + ", getType()=" + getType()
				+ ", getWidth()=" + getWidth() + ", getHeight()=" + getHeight() + "]";
	}

}
