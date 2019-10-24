package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import edu.northeastern.cs5200.Utility;
import edu.northeastern.cs5200.models.Person;
import edu.northeastern.cs5200.models.User;

/**
 * The Class UserDao.
 */
public class UserDao implements UserImpl {

	/** The instance. */
	private static UserDao instance;
	
	/** The person instance. */
	private static PersonDao personInstance;
	
	/** The connection. */
	private Connection connection;
	
	/** The prep statement. */
	private PreparedStatement prepStatement;
	
	/** The result set. */
	private ResultSet resultSet;
	
	/** The create user. */
	private final String CREATE_USER = "INSERT INTO `user`(`id`,`user_agreement`) VALUES (?,?)";
	
	/** The find all users. */
	private final String FIND_ALL_USERS = "SELECT `p`.*, `d`.*  FROM `user` `d` JOIN `person` p ON `d`.`id` = `p`.`id`";
	
	/** The find user by id. */
	private final String FIND_USER_BY_ID = "SELECT `p`.*, `d`.*  FROM `user` `d` JOIN `person` p ON `d`.`id` = `p`.`id` AND `d`.`id` = ?";
	
	/** The find user by username. */
	private final String FIND_USER_BY_USERNAME = "SELECT `p`.*, `d`.*  FROM `user` `d` JOIN `person` p ON `d`.`id` = `p`.`id` AND `p`.`id` in (SELECT `id` FROM `person` WHERE `username` = ?)";
	
	/** The find user by username and password. */
	private final String FIND_USER_BY_USERNAME_AND_PASSWORD = "SELECT `p`.*, `d`.*  FROM `user` `d` JOIN `person` p ON `d`.`id` = `p`.`id` AND `p`.`id` in (SELECT `id` FROM `person` WHERE `username` = ? and `password` = ?)";
	
	/** The update user. */
	private final String UPDATE_USER = "UPDATE `user` SET `user_agreement`= ? WHERE `id` = ?";
	
	/** The delete user. */
	private final String DELETE_USER = "DELETE FROM `user` WHERE `id` = ?";

	/**
	 * Instantiates a new user dao.
	 */
	private UserDao() {
	}

	/**
	 * Gets the single instance of UserDao.
	 *
	 * @return single instance of UserDao
	 */
	public static UserDao getInstance() {
		if (instance == null)
			instance = new UserDao();
		return instance;
	}

	/**
	 * Creates the user.
	 *
	 * @param user the user
	 */
	@Override
	public void createUser(User user) {
		personInstance = PersonDao.getInstance();
		if (personInstance.findPersonById(user.getId()) != null) {
			// log message that a person with same id already exists.
			return;
		} else {
			int id = personInstance.createPerson(new Person(user.getId(), user.getFirstName(), user.getLastName(),
					user.getUsername(), user.getPassword(), user.getEmail(), user.getDob()));

			if (id != 0) {
				try {
					connection = edu.northeastern.cs5200.Connection.getConnection();
					prepStatement = connection.prepareStatement(CREATE_USER);
					prepStatement.setInt(1, user.getId());
					prepStatement.setBoolean(2, user.isUserAgreement());
					prepStatement.execute();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}

			}
		}

	}

	/**
	 * Find all users.
	 *
	 * @return the collection
	 */
	@Override
	public Collection<User> findAllUsers() {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(FIND_ALL_USERS);
			resultSet = prepStatement.executeQuery();

			return Utility.getCollectionOfUsers(resultSet);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Find user by id.
	 *
	 * @param userId the user id
	 * @return the user
	 */
	@Override
	public User findUserById(int userId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(FIND_USER_BY_ID);
			prepStatement.setInt(1, userId);
			resultSet = prepStatement.executeQuery();
			Collection<User> users = Utility.getCollectionOfUsers(resultSet);
			return users != null && !users.isEmpty() ? (User) users.toArray()[0] : null;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Find user by username.
	 *
	 * @param username the username
	 * @return the user
	 */
	@Override
	public User findUserByUsername(String username) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(FIND_USER_BY_USERNAME);
			prepStatement.setString(1, username);
			resultSet = prepStatement.executeQuery();
			Collection<User> users = Utility.getCollectionOfUsers(resultSet);
			return users != null && !users.isEmpty() ? (User) users.toArray()[0] : null;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Find user by credentials.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the user
	 */
	@Override
	public User findUserByCredentials(String username, String password) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(FIND_USER_BY_USERNAME_AND_PASSWORD);
			prepStatement.setString(1, username);
			prepStatement.setString(2, password);
			resultSet = prepStatement.executeQuery();
			Collection<User> users = Utility.getCollectionOfUsers(resultSet);
			return users != null && !users.isEmpty() ? (User) users.toArray()[0] : null;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Update user.
	 *
	 * @param userId the user id
	 * @param user the user
	 * @return the int
	 */
	@Override
	public int updateUser(int userId, User user) {
		try {
			personInstance = PersonDao.getInstance();
			personInstance.updatePerson(userId,
					new Person(user.getId(), user.getFirstName(), user.getLastName(),
							user.getUsername(), user.getPassword(), user.getEmail(),
							user.getDob()));
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(UPDATE_USER);
			prepStatement.setBoolean(1, user.isUserAgreement());
			prepStatement.setInt(2, userId);
			return prepStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Delete user.
	 *
	 * @param userId the user id
	 * @return the int
	 */
	@Override
	public int deleteUser(int userId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(DELETE_USER);
			prepStatement.setInt(1, userId);
			int ret = prepStatement.executeUpdate();

			personInstance = PersonDao.getInstance();

			return personInstance.deletePerson(userId) >= 1 && ret >= 1 ? 1 : -1;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
