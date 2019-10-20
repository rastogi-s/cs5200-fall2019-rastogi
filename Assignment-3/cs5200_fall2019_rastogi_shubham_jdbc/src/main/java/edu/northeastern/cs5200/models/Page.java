package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;


/**
 * The Class Page.
 */
public class Page {
	
	/** The id. */
	private int id;
	
	/** The title. */
	private String title;
	
	/** The description. */
	private String description;
	
	/** The created. */
	private Date created;
	
	/** The updated. */
	private Date updated;
	
	/** The views. */
	private int views;
	
	/** The website. */
	private Website website;
	
	/** The widgets. */
	private Collection<Widget> widgets;

	
	/**
	 * Instantiates a new page.
	 *
	 * @param id the id
	 * @param title the title
	 * @param description the description
	 * @param created the created
	 * @param updated the updated
	 * @param views the views
	 */
	public Page(int id, String title, String description, Date created, Date updated, int views) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.views = views;
	}

	/**
	 * Gets the widgets.
	 *
	 * @return the widgets
	 */
	public Collection<Widget> getWidgets() {
		return widgets;
	}

	/**
	 * Sets the widgets.
	 *
	 * @param widgets the new widgets
	 */
	public void setWidgets(Collection<Widget> widgets) {
		this.widgets = widgets;
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
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the created.
	 *
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * Sets the created.
	 *
	 * @param created the new created
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * Gets the updated.
	 *
	 * @return the updated
	 */
	public Date getUpdated() {
		return updated;
	}

	/**
	 * Sets the updated.
	 *
	 * @param updated the new updated
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	/**
	 * Gets the views.
	 *
	 * @return the views
	 */
	public int getViews() {
		return views;
	}

	/**
	 * Sets the views.
	 *
	 * @param views the new views
	 */
	public void setViews(int views) {
		this.views = views;
	}

	/**
	 * Gets the website.
	 *
	 * @return the website
	 */
	public Website getWebsite() {
		return website;
	}

	/**
	 * Sets the website.
	 *
	 * @param website the new website
	 */
	public void setWebsite(Website website) {
		this.website = website;
	}
	
	

	/**
	 * Adds the widget.
	 *
	 * @param widget the widget
	 */
	public void addWidget(Widget widget) {
		if (this.widgets == null)
			this.widgets = new ArrayList<>();
		this.widgets.add(widget);
	}

	
	/**
	 * Removes the widget.
	 *
	 * @param widget the widget
	 */
	public void removeWidget(Widget widget) {
		if (this.widgets == null)
			return;
		this.widgets.remove(widget);
	}
	

}
