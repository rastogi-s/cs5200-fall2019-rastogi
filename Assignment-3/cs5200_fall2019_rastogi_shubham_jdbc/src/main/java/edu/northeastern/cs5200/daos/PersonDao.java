package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import edu.northeastern.cs5200.Utility;
import edu.northeastern.cs5200.models.Person;

/**
 * The Class PersonDao.
 */
public class PersonDao implements PersonImpl {

	/** The instance. */
	private static PersonDao instance;
	
	/** The connection. */
	private Connection connection;
	
	/** The prep statement. */
	private PreparedStatement prepStatement;
	
	/** The result set. */
	private ResultSet resultSet;
	
	/** The create person. */
	private final String CREATE_PERSON = "INSERT INTO `person`(`id`,`first_name`,`last_name`, `username`, `password`, `email`,`dob`) VALUES (?,?,?,?,?,?,?)";
	
	/** The find all persons. */
	private final String FIND_ALL_PERSONS = "SELECT * FROM `person`";
	
	/** The find person by id. */
	private final String FIND_PERSON_BY_ID = "SELECT * FROM `person` WHERE `id` = ?";
	
	/** The find person by username. */
	private final String FIND_PERSON_BY_USERNAME = "SELECT * FROM `person` WHERE `username` = ?";
	
	/** The find person by username and password. */
	private final String FIND_PERSON_BY_USERNAME_AND_PASSWORD = "SELECT * FROM `person` WHERE `username` = ? AND `password` = ?";
	
	/** The update person. */
	private final String UPDATE_PERSON = "UPDATE `person` SET `first_name` = ?,`last_name` = ?, `username` = ?, `password` = ?, `email` = ?, `dob` = ? WHERE `id` = ?";
	
	/** The delete person. */
	private final String DELETE_PERSON = "DELETE FROM `person` WHERE `id` = ?";

	/**
	 * Instantiates a new person dao.
	 */
	private PersonDao() {
	}

	/**
	 * Gets the single instance of PersonDao.
	 *
	 * @return single instance of PersonDao
	 */
	public static PersonDao getInstance() {
		if (instance == null)
			instance = new PersonDao();
		return instance;
	}

	/**
	 * Creates the person.
	 *
	 * @param person the person
	 * @return the int
	 */
	@Override
	public int createPerson(Person person) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(CREATE_PERSON);
			prepStatement.setInt(1, person.getId());
			prepStatement.setString(2, person.getFirstName());
			prepStatement.setString(3, person.getLastName());
			prepStatement.setString(4, person.getUsername());
			prepStatement.setString(5, person.getPassword());
			prepStatement.setString(6, person.getEmail());
			prepStatement.setDate(7, person.getDob());
			return prepStatement.executeUpdate();


		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return -1;

	}

	/**
	 * Find all persons.
	 *
	 * @return the collection
	 */
	@Override
	public Collection<Person> findAllPersons() {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(FIND_ALL_PERSONS);
			resultSet = prepStatement.executeQuery();

			return Utility.getCollectionOfPersons(resultSet);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * Find person by id.
	 *
	 * @param personId the person id
	 * @return the person
	 */
	@Override
	public Person findPersonById(int personId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(FIND_PERSON_BY_ID);
			prepStatement.setInt(1, personId);
			resultSet = prepStatement.executeQuery();
			Collection<Person> persons = Utility.getCollectionOfPersons(resultSet);
			return persons != null && !persons.isEmpty() ? (Person) persons.toArray()[0] : null;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * Find person by username.
	 *
	 * @param username the username
	 * @return the person
	 */
	@Override
	public Person findPersonByUsername(String username) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(FIND_PERSON_BY_USERNAME);
			prepStatement.setString(1, username);
			resultSet = prepStatement.executeQuery();
			Collection<Person> persons = Utility.getCollectionOfPersons(resultSet);
			return persons != null && !persons.isEmpty() ? (Person) persons.toArray()[0] : null;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Find person by credentials.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the person
	 */
	@Override
	public Person findPersonByCredentials(String username, String password) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(FIND_PERSON_BY_USERNAME_AND_PASSWORD);
			prepStatement.setString(1, username);
			prepStatement.setString(2, password);
			resultSet = prepStatement.executeQuery();
			Collection<Person> persons = Utility.getCollectionOfPersons(resultSet);
			return persons != null && !persons.isEmpty() ? (Person) persons.toArray()[0] : null;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Update person.
	 *
	 * @param personId the person id
	 * @param person the person
	 * @return the int
	 */
	@Override
	public int updatePerson(int personId, Person person) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(UPDATE_PERSON);
			prepStatement.setInt(1, personId);
			prepStatement.setString(2, person.getFirstName());
			prepStatement.setString(3, person.getLastName());
			prepStatement.setString(4, person.getUsername());
			prepStatement.setString(5, person.getPassword());
			prepStatement.setString(6, person.getEmail());
			prepStatement.setDate(7, person.getDob());
			return prepStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Delete person.
	 *
	 * @param personId the person id
	 * @return the int
	 */
	@Override
	public int deletePerson(int personId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(DELETE_PERSON);
			prepStatement.setInt(1, personId);
			return prepStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

}
