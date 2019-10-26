package edu.northeastern.cs5200.models;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class ListWidget.
 */
@Entity
@Table(name = "list_widget")
public class ListWidget extends Widget {

	/** The items. */
	private String[] items;

	/** The ordered. */
	private boolean ordered;

	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	public String[] getItems() {
		return items;
	}

	/**
	 * Sets the items.
	 *
	 * @param items the new items
	 */
	public void setItems(String[] items) {
		this.items = items;
	}

	/**
	 * Checks if is ordered.
	 *
	 * @return true, if is ordered
	 */
	public boolean isOrdered() {
		return ordered;
	}

	/**
	 * Sets the ordered.
	 *
	 * @param ordered the new ordered
	 */
	public void setOrdered(boolean ordered) {
		this.ordered = ordered;
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
		result = prime * result + Arrays.hashCode(items);
		result = prime * result + (ordered ? 1231 : 1237);
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
		ListWidget other = (ListWidget) obj;
		if (!Arrays.equals(items, other.items))
			return false;
		if (ordered != other.ordered)
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
		return "ListWidget [items=" + Arrays.toString(items) + ", ordered=" + ordered + ", getId()=" + getId()
				+ ", getType()=" + getType() + ", getWidth()=" + getWidth() + ", getHeight()=" + getHeight() + "]";
	}

}
