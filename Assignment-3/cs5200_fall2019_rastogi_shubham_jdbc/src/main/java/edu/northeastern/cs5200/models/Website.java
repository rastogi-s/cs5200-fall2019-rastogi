package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

/**
 * The Class Website.
 */

public class Website {

	/** The id. */
	private int id;

	/** The name. */
	private String name;

	/** The description. */
	private String description;

	/** The created. */
	private Date created;

	/** The updated. */
	private Date updated;

	/** The visits. */
	private int visits;

	/** The creator. */
	private Developer creator;

	/** The pages. */
	private Collection<Page> pages;

	/**
	 * Instantiates a new website.
	 *
	 * @param id          the id
	 * @param name        the name
	 * @param description the description
	 * @param created     the created
	 * @param updated     the updated
	 * @param visits      the visits
	 */
	public Website(int id, String name, String description, Date created, Date updated, int visits) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
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
	 * Gets the visits.
	 *
	 * @return the visits
	 */
	public int getVisits() {
		return visits;
	}

	/**
	 * Sets the visits.
	 *
	 * @param visits the new visits
	 */
	public void setVisits(int visits) {
		this.visits = visits;
	}

	/**
	 * Gets the creator.
	 *
	 * @return the creator
	 */
	public Developer getCreator() {
		return creator;
	}

	/**
	 * Sets the creator.
	 *
	 * @param creator the new creator
	 */
	public void setCreator(Developer creator) {
		this.creator = creator;
	}

	/**
	 * Gets the pages.
	 *
	 * @return the pages
	 */
	public Collection<Page> getPages() {
		return pages;
	}

	/**
	 * Sets the pages.
	 *
	 * @param pages the new pages
	 */
	public void setPages(Collection<Page> pages) {
		this.pages = pages;
	}

	/**
	 * Adds the page.
	 *
	 * @param page the page
	 */
	public void addPage(Page page) {
		if (this.pages == null)
			this.pages = new ArrayList<>();
		this.pages.add(page);
	}

	/**
	 * Removes the page.
	 *
	 * @param page the page
	 */
	public void removePage(Page page) {
		if (this.pages == null)
			return;
		this.pages.remove(page);
	}

}
