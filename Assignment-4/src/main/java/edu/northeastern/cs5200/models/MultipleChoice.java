package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class MultipleChoice.
 */
@Entity
@Table(name = "multiple_choice")
public class MultipleChoice extends Question {

	/** The choices. */
	private String choices;

	/** The correct. */
	private int correct;

	/**
	 * Gets the choices.
	 *
	 * @return the choices
	 */
	public String getChoices() {
		return choices;
	}

	/**
	 * Sets the choices.
	 *
	 * @param choices the new choices
	 */
	public void setChoices(String choices) {
		this.choices = choices;
	}

	/**
	 * Gets the correct.
	 *
	 * @return the correct
	 */
	public int getCorrect() {
		return correct;
	}

	/**
	 * Sets the correct.
	 *
	 * @param correct the new correct
	 */
	public void setCorrect(int correct) {
		this.correct = correct;
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
		result = prime * result + ((choices == null) ? 0 : choices.hashCode());
		result = prime * result + correct;
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
		MultipleChoice other = (MultipleChoice) obj;
		if (choices == null) {
			if (other.choices != null)
				return false;
		} else if (!choices.equals(other.choices))
			return false;
		if (correct != other.correct)
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
		return "MultipleChoice [choices=" + choices + ", correct=" + correct + ", getId()=" + getId()
				+ ", getQuestion()=" + getQuestion() + ", getPoints()=" + getPoints() + ", getQuiz()=" + getQuiz()
				+ "]";
	}

}
