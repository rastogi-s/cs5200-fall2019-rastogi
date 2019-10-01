package edu.northeastern.cs5200.controllers.hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The Class HelloObject.
 * 
 * @author Shubham Rastogi
 */
@Entity(name = "hello")
public class HelloObject {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	/** The message. */
	private String message;

	/**
	 * Instantiates a new hello object.
	 */
	public HelloObject() {

	}

	/**
	 * Instantiates a new hello object.
	 *
	 * @param message the message
	 */
	public HelloObject(String message) {
		super();
		this.message = message;
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
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
