package edu.northeastern.cs5200.models;

/**
 * The Class HtmlWidget.
 */
public class HtmlWidget extends Widget {
	
	/** The html. */
	private String html;
	
	
	/**
	 * Instantiates a new html widget.
	 *
	 * @param id the id
	 * @param name the name
	 * @param width the width
	 * @param height the height
	 * @param cssClass the css class
	 * @param cssStyle the css style
	 * @param text the text
	 * @param order the order
	 */
	public HtmlWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
			int order,String html) {
		super(id, name, width, height, cssClass, cssStyle, text, order);
		this.html = html;
	}
	
	
	/**
	 * Gets the html.
	 *
	 * @return the html
	 */
	public String getHtml() {
		return html;
	}

	/**
	 * Sets the html.
	 *
	 * @param html the new html
	 */
	public void setHtml(String html) {
		this.html = html;
	}
	
}
