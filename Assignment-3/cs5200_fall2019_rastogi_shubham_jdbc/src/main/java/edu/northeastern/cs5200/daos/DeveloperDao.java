package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import edu.northeastern.cs5200.Utility;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.Person;

public class DeveloperDao implements DeveloperImpl {

	private static DeveloperDao instance;
	private static PersonDao personInstance;
	private Connection connection;
	private PreparedStatement prepStatement;
	private ResultSet resultSet;
	private final String CREATE_DEVELOPER = "INSERT INTO `developer`(`id`,`developer_key`) VALUES (?,?)";
	private final String FIND_ALL_DEVELOPERS = "SELECT `p`.*, `d`.*  FROM `developer` `d` JOIN `person` p ON `d`.`id` = `p`.`id`";
	private final String FIND_DEVELOPER_BY_ID = "SELECT `p`.*, `d`.*  FROM `developer` `d` JOIN `person` p ON `d`.`id` = `p`.`id` AND `d`.`id` = ?";
	private final String FIND_DEVELOPER_BY_USERNAME = "SELECT `p`.*, `d`.*  FROM `developer` `d` JOIN `person` p ON `d`.`id` = `p`.`id` AND `p`.`id` in (SELECT `id` FROM `person` WHERE `username` = ?)";
	private final String FIND_DEVELOPER_BY_USERNAME_AND_PASSWORD = "SELECT `p`.*, `d`.*  FROM `developer` `d` JOIN `person` p ON `d`.`id` = `p`.`id` AND `p`.`id` in (SELECT `id` FROM `person` WHERE `username` = ? and `password` = ?)";
	private final String UPDATE_DEVELOPER = "UPDATE `developer` SET `developer_key`= ? WHERE `id` = ?";
	private final String DELETE_DEVELOPER = "DELETE FROM `developer` WHERE `id` = ?";

	private DeveloperDao() {
	}

	public static DeveloperDao getInstance() {
		if (instance == null)
			instance = new DeveloperDao();
		return instance;
	}

	@Override
	public void createDeveloper(Developer developer) {
		personInstance = PersonDao.getInstance();
		if (personInstance.findPersonById(developer.getId()) != null) {
			// log message that a person with same id already exists.
			return;
		} else {
			int id = personInstance.createPerson(new Person(developer.getId(), developer.getFirstName(),
					developer.getLastName(), developer.getUsername(), developer.getPassword(), developer.getEmail(),
					developer.getDob()));

			if (id != 0) {
				try {
					connection = edu.northeastern.cs5200.Connection.getConnection();
					prepStatement = connection.prepareStatement(CREATE_DEVELOPER);
					prepStatement.setInt(1, developer.getId());
					prepStatement.setString(2, developer.getDeveloperKey());

					prepStatement.execute();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}

			}
		}

	}

	@Override
	public Collection<Developer> findAllDevelopers() {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(FIND_ALL_DEVELOPERS);
			resultSet = prepStatement.executeQuery();

			return Utility.getCollectionOfDevelopers(resultSet);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Developer findDeveloperById(int developerId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(FIND_DEVELOPER_BY_ID);
			prepStatement.setInt(1, developerId);
			resultSet = prepStatement.executeQuery();
			Collection<Developer> developers = Utility.getCollectionOfDevelopers(resultSet);
			return developers != null && !developers.isEmpty() ? (Developer) developers.toArray()[0] : null;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Developer findDeveloperByUsername(String username) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(FIND_DEVELOPER_BY_USERNAME);
			prepStatement.setString(1, username);
			resultSet = prepStatement.executeQuery();
			Collection<Developer> developers = Utility.getCollectionOfDevelopers(resultSet);
			return developers != null && !developers.isEmpty() ? (Developer) developers.toArray()[0] : null;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Developer findDeveloperByCredentials(String username, String password) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(FIND_DEVELOPER_BY_USERNAME_AND_PASSWORD);
			prepStatement.setString(1, username);
			prepStatement.setString(2, password);
			resultSet = prepStatement.executeQuery();
			Collection<Developer> developers = Utility.getCollectionOfDevelopers(resultSet);
			return developers != null && !developers.isEmpty() ? (Developer) developers.toArray()[0] : null;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int updateDeveloper(int developerId, Developer developer) {
		try {
			personInstance = PersonDao.getInstance();
			personInstance.updatePerson(developerId,
					new Person(developer.getId(), developer.getFirstName(), developer.getLastName(),
							developer.getUsername(), developer.getPassword(), developer.getEmail(),
							developer.getDob()));
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(UPDATE_DEVELOPER);
			prepStatement.setString(1, developer.getDeveloperKey());
			prepStatement.setInt(2, developerId);
			return prepStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteDeveloper(int developerId) {
		try {

			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(DELETE_DEVELOPER);
			prepStatement.setInt(1, developerId);
			int ret = prepStatement.executeUpdate();

			personInstance = PersonDao.getInstance();

			return personInstance.deletePerson(developerId) >= 1 && ret >= 1 ? 1 : -1;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
