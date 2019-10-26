package edu.northeastern.cs5200.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class YouTubeWidget.
 */
@Entity
@Table(name = "youtube_widget")
public class YouTubeWidget extends Widget {

	/** The youTubeId. */
	@Column(name = "youtube_id")
	private String youTubeId;

	/**
	 * Gets the you tube id.
	 *
	 * @return the you tube id
	 */
	public String getYouTubeId() {
		return youTubeId;
	}

	/**
	 * Sets the you tube id.
	 *
	 * @param youTubeId the new you tube id
	 */
	public void setYouTubeId(String youTubeId) {
		this.youTubeId = youTubeId;
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
		result = prime * result + ((youTubeId == null) ? 0 : youTubeId.hashCode());
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
		YouTubeWidget other = (YouTubeWidget) obj;
		if (youTubeId == null) {
			if (other.youTubeId != null)
				return false;
		} else if (!youTubeId.equals(other.youTubeId))
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
		return "YouTubeWidget [youTubeId=" + youTubeId + "]";
	}

}
