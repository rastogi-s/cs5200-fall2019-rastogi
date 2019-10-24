package edu.northeastern.cs5200.models;

/**
 * The Class YouTubeWidget.
 */
public class YouTubeWidget extends Widget {

	

	/** The url. */
	private String url;

	/** The shareble. */
	private boolean shareble;

	/** The expandable. */
	private boolean expandable;
	
	/**
	 * Instantiates a new you tube widget.
	 *
	 * @param id the id
	 * @param name the name
	 * @param width the width
	 * @param height the height
	 * @param cssClass the css class
	 * @param cssStyle the css style
	 * @param text the text
	 * @param order the order
	 * @param url the url
	 * @param shareble the shareble
	 * @param expandable the expandable
	 */
	public YouTubeWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
			int order,String url,boolean shareble,boolean expandable) {
		super(id, name, width, height, cssClass, cssStyle, text, order);
		this.url = url;
		this.shareble = shareble;
		this.expandable = expandable;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Checks if is shareble.
	 *
	 * @return true, if is shareble
	 */
	public boolean isShareble() {
		return shareble;
	}

	/**
	 * Sets the shareble.
	 *
	 * @param shareble the new shareble
	 */
	public void setShareble(boolean shareble) {
		this.shareble = shareble;
	}

	/**
	 * Checks if is expandable.
	 *
	 * @return true, if is expandable
	 */
	public boolean isExpandable() {
		return expandable;
	}

	/**
	 * Sets the expandable.
	 *
	 * @param expandable the new expandable
	 */
	public void setExpandable(boolean expandable) {
		this.expandable = expandable;
	}

}
