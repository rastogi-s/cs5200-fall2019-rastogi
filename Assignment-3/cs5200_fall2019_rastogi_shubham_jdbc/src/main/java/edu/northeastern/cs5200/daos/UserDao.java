package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import edu.northeastern.cs5200.Utility;
import edu.northeastern.cs5200.models.Person;
import edu.northeastern.cs5200.models.User;

public class UserDao implements UserImpl {

	private static UserDao instance;
	private static PersonDao personInstance;
	private Connection connection;
	private PreparedStatement prepStatement;
	private ResultSet resultSet;
	private final String CREATE_USER = "INSERT INTO `user`(`id`,`user_agreement`) VALUES (?,?)";
	private final String FIND_ALL_USERS = "SELECT `p`.*, `d`.*  FROM `user` `d` JOIN `person` p ON `d`.`id` = `p`.`id`";
	private final String FIND_USER_BY_ID = "SELECT `p`.*, `d`.*  FROM `user` `d` JOIN `person` p ON `d`.`id` = `p`.`id` AND `d`.`id` = ?";
	private final String FIND_USER_BY_USERNAME = "SELECT `p`.*, `d`.*  FROM `user` `d` JOIN `person` p ON `d`.`id` = `p`.`id` AND `p`.`id` in (SELECT `id` FROM `person` WHERE `username` = ?)";
	private final String FIND_USER_BY_USERNAME_AND_PASSWORD = "SELECT `p`.*, `d`.*  FROM `user` `d` JOIN `person` p ON `d`.`id` = `p`.`id` AND `p`.`id` in (SELECT `id` FROM `person` WHERE `username` = ? and `password` = ?)";
	private final String UPDATE_USER = "UPDATE `user` SET `user_agreement`= ? WHERE `id` = ?";
	private final String DELETE_USER = "DELETE FROM `user` WHERE `id` = ?";

	private UserDao() {
	}

	public static UserDao getInstance() {
		if (instance == null)
			instance = new UserDao();
		return instance;
	}

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
