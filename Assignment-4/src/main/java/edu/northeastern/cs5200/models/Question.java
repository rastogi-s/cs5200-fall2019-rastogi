package edu.northeastern.cs5200.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * The Class Question.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Question {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/** The question. */
	private String question;

	/** The points. */
	private int points;

	/** The quiz. */
	@ManyToOne
	private QuizWidget quiz;

	/** The answers. */
	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
	private List<Answer> answers;

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
	 * Gets the question.
	 *
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * Sets the question.
	 *
	 * @param question the new question
	 */
	public void setQuestion(String question) {
		this.question = question;

	}

	/**
	 * Gets the points.
	 *
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Sets the points.
	 *
	 * @param points the new points
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * Gets the quiz.
	 *
	 * @return the quiz
	 */
	public QuizWidget getQuiz() {
		return quiz;
	}

	/**
	 * Sets the quiz.
	 *
	 * @param quiz the new quiz
	 */
	public void setQuiz(QuizWidget quiz) {
		this.quiz = quiz;
		if (quiz.getQuestions() == null) {
			quiz.addQuestion(this);
		} else if (!quiz.getQuestions().contains(this)) {
			quiz.getQuestions().add(this);
		}
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
		answers.add(answer);
		if (answer.getQuestion() != this)
			answer.setQuestion(this);
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
		result = prime * result + ((answers == null) ? 0 : answers.hashCode());
		result = prime * result + id;
		result = prime * result + points;
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + ((quiz == null) ? 0 : quiz.hashCode());
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
		Question other = (Question) obj;
		if (answers == null) {
			if (other.answers != null)
				return false;
		} else if (!answers.equals(other.answers))
			return false;
		if (id != other.id)
			return false;
		if (points != other.points)
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (quiz == null) {
			if (other.quiz != null)
				return false;
		} else if (!quiz.equals(other.quiz))
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
		return "Question [id=" + id + ", question=" + question + ", points=" + points + ", quiz=" + quiz + ", answers="
				+ answers + "]";
	}

}
