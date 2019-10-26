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
 * The Class Topic.
 */
@Entity
public class Topic {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/** The label. */
	private String label;

	/** The lesson. */
	@ManyToOne
	private Lesson lesson;

	/** The widgets. */
	@OneToMany(mappedBy = "topic", fetch = FetchType.EAGER)
	private List<Widget> widgets;

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
	 * Gets the lesson.
	 *
	 * @return the lesson
	 */
	public Lesson getLesson() {
		return lesson;
	}

	/**
	 * Sets the lesson.
	 *
	 * @param lesson the new lesson
	 */
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
		if (lesson.getTopics() == null) {
			lesson.addTopic(this);
		} else if (!lesson.getTopics().contains(this)) {
			lesson.getTopics().add(this);
		}
	}

	/**
	 * Gets the widgets.
	 *
	 * @return the widgets
	 */
	public List<Widget> getWidgets() {
		return widgets;
	}

	/**
	 * Sets the widgets.
	 *
	 * @param widgets the new widgets
	 */
	public void setWidgets(List<Widget> widgets) {
		this.widgets = widgets;
	}

	/**
	 * Adds the widgets.
	 *
	 * @param widget the widget
	 */
	public void addWidget(Widget widget) {
		if (widgets == null)
			widgets = new ArrayList<>();
		widgets.add(widget);
		if (widget.getTopic() != this)
			widget.setTopic(this);
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
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((lesson == null) ? 0 : lesson.hashCode());
		result = prime * result + ((widgets == null) ? 0 : widgets.hashCode());
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
		Topic other = (Topic) obj;
		if (id != other.id)
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (lesson == null) {
			if (other.lesson != null)
				return false;
		} else if (!lesson.equals(other.lesson))
			return false;
		if (widgets == null) {
			if (other.widgets != null)
				return false;
		} else if (!widgets.equals(other.widgets))
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
		return "Topic [id=" + id + ", label=" + label + ", lesson=" + lesson + ", widgets=" + widgets + "]";
	}

}
