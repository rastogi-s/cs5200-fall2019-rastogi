package edu.northeastern.cs5200.models;

/**
 * The Class ImageWidget.
 */
public class ImageWidget extends Widget {

	/** The src. */
	private String src;

	/**
	 * Instantiates a new image widget.
	 *
	 * @param id the id
	 * @param name the name
	 * @param width the width
	 * @param height the height
	 * @param cssClass the css class
	 * @param cssStyle the css style
	 * @param text the text
	 * @param order the order
	 * @param src the src
	 */
	public ImageWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
			int order,String src) {
		super(id, name, width, height, cssClass, cssStyle, text, order);
		this.src = src;
	}

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

}
