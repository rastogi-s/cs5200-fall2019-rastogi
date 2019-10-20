package edu.northeastern.cs5200.daos;

import java.util.Collection;

import edu.northeastern.cs5200.models.Person;

public interface PersonImpl {

	/**
	 * Creates the person.
	 * returns the id of the person created.
	 * 
	 * @param person the person
	 * @return the int
	 */
	int createPerson(Person person);

	/**
	 * Find all persons.
	 * 
	 * @return the collection
	 */
	Collection<Person> findAllPersons();

	/**
	 * Find person by id.
	 *
	 * @param personId the person id
	 * @return the person
	 */
	Person findPersonById(int personId);

	/**
	 * Find person by username.
	 * 
	 * @param username the username
	 * @return the person
	 */
	Person findPersonByUsername(String username);

	/**
	 * Find person by credentials.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the person
	 */
	Person findPersonByCredentials(String username, String password);

	/**
	 * Update person.
	 *
	 * 
	 * @param personId the person id
	 * @param person   the person
	 * @return the int
	 */
	int updatePerson(int personId, Person person);

	/**
	 * Delete person.
	 * 
	 * @param personId the person id
	 * @return the int
	 */
	int deletePerson(int personId);

}
