package edu.northeastern.cs5200.models;

/**
 * The Class HeadingWidget.
 */
public class HeadingWidget extends Widget {
	
	/** The size. */
	private int size;
	
	/**
	 * Instantiates a new heading widget.
	 *
	 * @param id the id
	 * @param name the name
	 * @param width the width
	 * @param height the height
	 * @param cssClass the css class
	 * @param cssStyle the css style
	 * @param text the text
	 * @param order the order
	 * @param size the size
	 */
	public HeadingWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
			int order, int size) {
		super(id, name, width, height, cssClass, cssStyle, text, order);
		this.size = size;
	}

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
	
}
