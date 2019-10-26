package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class ImageWidget.
 */
@Entity
@Table(name = "image_widget")
public class ImageWidget extends Widget {

	/** The src. */
	private String src;

	/**
	 * Gets the src.
	 *
	 * @return the src
	 */
	public String getSrc() {
		return src;
	}

	/**
	 * Sets the src.
	 *
	 * @param src the new src
	 */
	public void setSrc(String src) {
		this.src = src;
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
		result = prime * result + ((src == null) ? 0 : src.hashCode());
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
		ImageWidget other = (ImageWidget) obj;
		if (src == null) {
			if (other.src != null)
				return false;
		} else if (!src.equals(other.src))
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
		return "ImageWidget [src=" + src + ", getId()=" + getId() + ", getType()=" + getType() + ", getWidth()="
				+ getWidth() + ", getHeight()=" + getHeight() + "]";
	}

}
