package edu.northeastern.cs5200.daos;

import java.util.Collection;

import edu.northeastern.cs5200.models.User;

/**
 * The Interface UserImpl.
 */
public interface UserImpl {
	
	/**
	 * Creates the user. Inserts properties in user instance parameter in
	 * tables User and Person.
	 *
	 * @param user the user
	 */
	void createUser(User user);

	/**
	 * Find all users. Returns all joined records from User and Person
	 * tables as a Collection of User instances.
	 *
	 * 
	 * @return the collection
	 */
	Collection<User> findAllUsers();

	/**
	 * Find user by id.Returns a joined record from User and Person tables
	 * whose id field is equal to the userId parameter
	 *
	 * @param userId the user id
	 * @return the user
	 */
	User findUserById(int userId);

	/**
	 * Find user by username. Returns a joined record from User and Person
	 * tables whose username field matches the parameter.
	 * 
	 * @param username the username
	 * @return the user
	 */
	User findUserByUsername(String username);

	/**
	 * Find user by credentials.Returns a joined record from User and
	 * Person tables whose username and password fields match the parameters er.
	 *
	 * 
	 * @param username the username
	 * @param password the password
	 * @return the user
	 */
	User findUserByCredentials(String username, String password);

	/**
	 * Update user. Updates records in User and Person tables whose id
	 * field is equal to userId parameter. New record field values are set to
	 * the values in the user instance parameter.
	 *
	 * 
	 * @param userId the user id
	 * @param user   the user
	 * @return the int
	 */
	int updateUser(int userId, User user);

	/**
	 * Delete user. Deletes records from User and Person tables whose id
	 * field is equal to userId parameter. Do not make any modifications to the
	 * instance provided.
	 *
	 * 
	 * @param userId the user id
	 * @return the int
	 */
	int deleteUser(int userId);


}
