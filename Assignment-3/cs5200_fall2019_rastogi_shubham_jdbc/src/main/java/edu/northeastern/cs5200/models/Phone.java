package edu.northeastern.cs5200.models;

/**
 * The Class Phone.
 */
public class Phone {
	
	
	/** The id. */
	private int id;

	/** The phone. */
	private String phone;
	
	/** The primary. */
	private boolean primary;
	
	/** The person. */
	private Person person;
	
	
	
	
	/**
	 * Instantiates a new phone.
	 *
	 * @param phone the phone
	 * @param primary the primary
	 */
	public Phone(String phone, boolean primary) {
		super();
		this.phone = phone;
		this.primary = primary;
	}

	/**
	 * Instantiates a new phone.
	 *
	 * @param id the id
	 * @param phone the phone
	 * @param primary the primary
	 */
	public Phone(int id, String phone, boolean primary) {
		super();
		this.id = id;
		this.phone = phone;
		this.primary = primary;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Checks if is primary.
	 *
	 * @return true, if is primary
	 */
	public boolean isPrimary() {
		return primary;
	}

	/**
	 * Sets the primary.
	 *
	 * @param primary the new primary
	 */
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}

	/**
	 * Gets the person.
	 *
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * Sets the person.
	 *
	 * @param person the new person
	 */
	public void setPerson(Person person) {
		this.person = person;
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
	
	

}
