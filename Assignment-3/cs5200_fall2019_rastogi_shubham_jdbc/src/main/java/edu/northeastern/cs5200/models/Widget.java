package edu.northeastern.cs5200.models;


/**
 * The Class Widget.
 */
public class Widget {

	/** The id. */
	private int id;

	/** The name. */
	private String name;
	
	/** The width. */
	private int width;
	
	/** The height. */
	private int height;
	
	/** The css class. */
	private String cssClass;
	
	/** The css style. */
	private String cssStyle;
	
	/** The text. */
	private String text;
	
	/** The order. */
	private int order;
	
	/** The page. */
	private Page page;
	

	/**
	 * Instantiates a new widget.
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
	public Widget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
			int order) {
		super();
		this.id = id;
		this.name = name;
		this.width = width;
		this.height = height;
		this.cssClass = cssClass;
		this.cssStyle = cssStyle;
		this.text = text;
		this.order = order;
	}

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
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width.
	 *
	 * @param width the new width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Gets the css class.
	 *
	 * @return the css class
	 */
	public String getCssClass() {
		return cssClass;
	}

	/**
	 * Sets the css class.
	 *
	 * @param cssClass the new css class
	 */
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	/**
	 * Gets the css style.
	 *
	 * @return the css style
	 */
	public String getCssStyle() {
		return cssStyle;
	}

	/**
	 * Sets the css style.
	 *
	 * @param cssStyle the new css style
	 */
	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 *
	 * @param text the new text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets the order.
	 *
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * Sets the order.
	 *
	 * @param order the new order
	 */
	public void setOrder(int order) {
		this.order = order;
	}

	/**
	 * Gets the page.
	 *
	 * @return the page
	 */
	public Page getPage() {
		return page;
	}

	/**
	 * Sets the page.
	 *
	 * @param page the new page
	 */
	public void setPage(Page page) {
		this.page = page;
	}

}
