package edu.northeastern.cs5200.daos;

import java.util.Collection;

import edu.northeastern.cs5200.models.Developer;

/**
 * The Interface DeveloperImpl.
 */
public interface DeveloperImpl {

	/**
	 * Creates the developer. Inserts properties in developer instance parameter in
	 * tables Developer and Person.
	 *
	 * @param developer the developer
	 */
	void createDeveloper(Developer developer);

	/**
	 * Find all developers. Returns all joined records from Developer and Person
	 * tables as a Collection of Developer instances.
	 *
	 * 
	 * @return the collection
	 */
	Collection<Developer> findAllDevelopers();

	/**
	 * Find developer by id.Returns a joined record from Developer and Person tables
	 * whose id field is equal to the developerId parameter
	 *
	 * @param developerId the developer id
	 * @return the developer
	 */
	Developer findDeveloperById(int developerId);

	/**
	 * Find developer by username. Returns a joined record from Developer and Person
	 * tables whose username field matches the parameter.
	 * 
	 * @param username the username
	 * @return the developer
	 */
	Developer findDeveloperByUsername(String username);

	/**
	 * Find developer by credentials.Returns a joined record from Developer and
	 * Person tables whose username and password fields match the parameters er.
	 *
	 * 
	 * @param username the username
	 * @param password the password
	 * @return the developer
	 */
	Developer findDeveloperByCredentials(String username, String password);

	/**
	 * Update developer. Updates records in Developer and Person tables whose id
	 * field is equal to developerId parameter. New record field values are set to
	 * the values in the developer instance parameter.
	 *
	 * 
	 * @param developerId the developer id
	 * @param developer   the developer
	 * @return the int
	 */
	int updateDeveloper(int developerId, Developer developer);

	/**
	 * Delete developer. Deletes records from Developer and Person tables whose id
	 * field is equal to developerId parameter. Do not make any modifications to the
	 * instance provided.
	 *
	 * 
	 * @param developerId the developer id
	 * @return the int
	 */
	int deleteDeveloper(int developerId);

}
