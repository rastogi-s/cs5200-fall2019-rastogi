package edu.northeastern.cs5200.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class TrueFalse.
 */
@Entity
@Table(name = "true_false")
public class TrueFalse extends Question {

	/** The is true. */
	@Column(name = "is_true")
	private boolean isTrue;

	/**
	 * Checks if is true.
	 *
	 * @return true, if is true
	 */
	public boolean isTrue() {
		return isTrue;
	}

	/**
	 * Sets the true.
	 *
	 * @param isTrue the new true
	 */
	public void setTrue(boolean isTrue) {
		this.isTrue = isTrue;
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
		result = prime * result + (isTrue ? 1231 : 1237);
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
		TrueFalse other = (TrueFalse) obj;
		if (isTrue != other.isTrue)
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
		return "TrueFalse [isTrue=" + isTrue + ", getId()=" + getId() + ", getQuestion()=" + getQuestion()
				+ ", getPoints()=" + getPoints() + ", getQuiz()=" + getQuiz() + "]";
	}

}
