package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

/**
 * The Class Developers.
 */
public class Developer extends Person {

	/** The developer key. */
	private String developerKey;

	/** The websites. */
	private Collection<Website> websites;

	/**
	 * Instantiates a new developer.
	 *
	 * @param developerKey the developer key
	 * @param id           the id
	 * @param firstName    the first name
	 * @param lastName     the last name
	 * @param username     the username
	 * @param password     the password
	 * @param email        the email
	 * @param dob          the dob
	 * @param phones       the phones
	 */
	public Developer(String developerKey, int id, String firstName, String lastName, String username, String password,
			String email, Date dob, Collection<Phone> phones) {
		super(id, firstName, lastName, username, password, email, dob, phones);
		this.developerKey = developerKey;
	}

	/**
	 * Instantiates a new developer.
	 *
	 * @param developerKey the developer key
	 * @param id           the id
	 * @param firstName    the first name
	 * @param lastName     the last name
	 * @param username     the username
	 * @param password     the password
	 * @param email        the email
	 * @param dob          the dob
	 */
	public Developer(String developerKey, int id, String firstName, String lastName, String username, String password,
			String email, Date dob) {
		super(id, firstName, lastName, username, password, email, dob);
		this.developerKey = developerKey;
	}

	/**
	 * Instantiates a new developer.
	 *
	 * @param developerKey the developer key
	 * @param id           the id
	 * @param firstName    the first name
	 * @param lastName     the last name
	 */
	public Developer(String developerKey, int id, String firstName, String lastName) {
		super(id, firstName, lastName);
		this.developerKey = developerKey;
	}

	/**
	 * Gets the developer key.
	 *
	 * @return the developer key
	 */
	public String getDeveloperKey() {
		return developerKey;
	}

	/**
	 * Sets the developer key.
	 *
	 * @param developerKey the new developer key
	 */
	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}

	/**
	 * Gets the websites.
	 *
	 * @return the websites
	 */
	public Collection<Website> getWebsites() {
		return websites;
	}

	/**
	 * Sets the websites.
	 *
	 * @param websites the new websites
	 */
	public void setWebsites(Collection<Website> websites) {
		this.websites = websites;
	}

	/**
	 * Adds the website.
	 *
	 * @param website the website
	 */
	public void addWebsite(Website website) {
		if (this.websites == null)
			this.websites = new ArrayList<>();
		this.websites.add(website);
	}

	/**
	 * Removes the website.
	 *
	 * @param website the website
	 */
	public void removeWebsite(Website website) {
		if (this.websites == null)
			return;
		this.websites.remove(website);
	}

	@Override
	public String toString() {
		return "Developer [developerKey=" + developerKey + ", websites=" + websites + ", getId()=" + getId()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getUsername()="
				+ getUsername() + ", getPassword()=" + getPassword() + ", getEmail()=" + getEmail() + ", getDob()="
				+ getDob() + "]";
	}
	
	

}
