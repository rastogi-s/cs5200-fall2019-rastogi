package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.Collection;

/**
 * The Class User.
 */
public class User extends Person {

	/** The user agreement. */
	private boolean userAgreement;

	/**
	 * Instantiates a new user.
	 *
	 * @param id        the id
	 * @param firstName the first name
	 * @param lastName  the last name
	 */
	public User(int id, String firstName, String lastName) {
		super(id, firstName, lastName);
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param id        the id
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @param username  the username
	 * @param password  the password
	 * @param email     the email
	 * @param dob       the dob
	 */
	public User(int id, String firstName, String lastName, String username, String password, String email, Date dob) {
		super(id, firstName, lastName, username, password, email, dob);

	}

	/**
	 * Instantiates a new user.
	 *
	 * @param id            the id
	 * @param firstName     the first name
	 * @param lastName      the last name
	 * @param username      the username
	 * @param password      the password
	 * @param email         the email
	 * @param dob           the dob
	 * @param phones        the phones
	 * @param userAgreement the user agreement
	 */
	public User(int id, String firstName, String lastName, String username, String password, String email, Date dob,
			Collection<Phone> phones, boolean userAgreement) {
		super(id, firstName, lastName, username, password, email, dob, phones);
		this.userAgreement = userAgreement;
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param id            the id
	 * @param firstName     the first name
	 * @param lastName      the last name
	 * @param username      the username
	 * @param password      the password
	 * @param email         the email
	 * @param dob           the dob
	 * @param userAgreement the user agreement
	 */
	public User(int id, String firstName, String lastName, String username, String password, String email, Date dob,
			boolean userAgreement) {
		super(id, firstName, lastName, username, password, email, dob);
		this.userAgreement = userAgreement;
	}

	/**
	 * Checks if is user agreement.
	 *
	 * @return true, if is user agreement
	 */
	public boolean isUserAgreement() {
		return userAgreement;
	}

	/**
	 * Sets the user agreement.
	 *
	 * @param userAgreement the new user agreement
	 */
	public void setUserAgreement(boolean userAgreement) {
		this.userAgreement = userAgreement;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "User [userAgreement=" + userAgreement + ", getPhones()=" + getPhones() + ", getAddresses()="
				+ getAddresses() + ", getId()=" + getId() + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword()
				+ ", getEmail()=" + getEmail() + ", getDob()=" + getDob() + "]";
	}
	
	

}
