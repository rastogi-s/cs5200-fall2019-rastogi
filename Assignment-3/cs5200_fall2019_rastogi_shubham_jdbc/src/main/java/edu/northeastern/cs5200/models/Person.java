package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

/**
 * The Class Person.
 */
public class Person {

	/** The id. */
	private int id;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The username. */
	private String username;

	/** The password. */
	private String password;

	/** The email. */
	private String email;

	/** The dob. */
	private Date dob;

	/** The phones. */
	private Collection<Phone> phones;

	/** The addresses. */
	private Collection<Address> addresses;
	
	
	/**
	 * Instantiates a new person.
	 *
	 * @param id        the id
	 * @param firstName the first name
	 * @param lastName  the last name
	 */
	public Person(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Instantiates a new person.
	 *
	 * @param id        the id
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @param username  the username
	 * @param password  the password
	 * @param email     the email
	 * @param dob       the dob
	 */
	public Person(int id, String firstName, String lastName, String username, String password, String email, Date dob) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
	}

	/**
	 * Instantiates a new person.
	 *
	 * @param id        the id
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @param username  the username
	 * @param password  the password
	 * @param email     the email
	 * @param dob       the dob
	 * @param phones    the phones
	 */
	public Person(int id, String firstName, String lastName, String username, String password, String email, Date dob,
			Collection<Phone> phones) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
		this.phones = phones;
	}

	/**
	 * Gets the phones.
	 *
	 * @return the phones
	 */
	public Collection<Phone> getPhones() {
		return phones;
	}

	/**
	 * Sets the phones.
	 *
	 * @param phones the new phones
	 */
	public void setPhones(Collection<Phone> phones) {
		this.phones = phones;
	}

	/**
	 * Gets the addresses.
	 *
	 * @return the addresses
	 */
	public Collection<Address> getAddresses() {
		return addresses;
	}

	/**
	 * Sets the addresses.
	 *
	 * @param addresses the new addresses
	 */
	public void setAddresses(Collection<Address> addresses) {
		this.addresses = addresses;
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
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the dob.
	 *
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * Sets the dob.
	 *
	 * @param dob the new dob
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * Adds the phone.
	 *
	 * @param phone the phone
	 */
	public void addPhone(Phone phone) {
		if (this.phones == null)
			this.phones = new ArrayList<>();
		this.phones.add(phone);
	}

	/**
	 * Removes the phone.
	 *
	 * @param phone the phone
	 */
	public void removePhone(Phone phone) {
		if (this.phones == null)
			return;
		this.phones.remove(phone);
	}

	/**
	 * Adds the address.
	 *
	 * @param address the address
	 */
	public void addAddress(Address address) {
		if (this.addresses == null)
			this.addresses = new ArrayList<>();
		this.addresses.add(address);
	}

	/**
	 * Removes the address.
	 *
	 * @param address the address
	 */
	public void removeAddress(Address address) {
		if (this.addresses == null)
			return;
		this.addresses.remove(address);
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", dob=" + dob + ", phones=" + phones + ", addresses="
				+ addresses + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	

}
