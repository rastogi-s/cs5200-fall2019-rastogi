package edu.northeastern.cs5200.controllers.hello;

/**
 * The Class HelloObject.
 * 
 * @author Shubham Rastogi
 */
public class HelloObject {
	
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
