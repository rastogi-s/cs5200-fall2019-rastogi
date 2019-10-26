package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class HeadingWidget.
 */
@Entity
@Table(name = "heading_widget")
public class HeadingWidget extends Widget {

	/** The size. */
	private int size;

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Sets the size.
	 *
	 * @param size the new size
	 */
	public void setSize(int size) {
		this.size = size;
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
		result = prime * result + size;
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
		HeadingWidget other = (HeadingWidget) obj;
		if (size != other.size)
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
		return "HeadingWidget [size=" + size + ", getId()=" + getId() + ", getType()=" + getType() + ", getWidth()="
				+ getWidth() + ", getHeight()=" + getHeight() + "]";
	}

}
