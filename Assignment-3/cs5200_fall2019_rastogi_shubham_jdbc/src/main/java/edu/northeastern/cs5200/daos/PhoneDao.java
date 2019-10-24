package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import edu.northeastern.cs5200.Utility;
import edu.northeastern.cs5200.models.Phone;


/**
 * The Class PhoneDao.
 */
public class PhoneDao implements PhoneImpl {

	/** The instance. */
	private static PhoneDao instance;
	
	/** The connection. */
	private Connection connection;
	
	/** The prep statement. */
	private PreparedStatement prepStatement;
	
	/** The result set. */
	private ResultSet resultSet;
	
	/** The add phone person. */
	private final String ADD_PHONE_PERSON = "INSERT INTO `phone`(`pid`,`phone`,`primary`) VALUES(?,?,?)";
	
	/** The find all phones person. */
	private final String FIND_ALL_PHONES_PERSON = "SELECT * FROM `phone` WHERE `pid` = ?";
	
	/** The find phone by id. */
	private final String FIND_PHONE_BY_ID = "SELECT * FROM `phone` WHERE `id` = ?";
	
	/** The update primary phone. */
	private final String UPDATE_PRIMARY_PHONE = "UPDATE `phone` SET `phone` = ? WHERE `pid` = ? AND `primary` = 1";
	
	/** The update phone. */
	private final String UPDATE_PHONE = "UPDATE `phone` SET `phone` = ?,`pid` = ? WHERE `id` = ? ";
	
	/** The delete phone. */
	private final String DELETE_PHONE = "DELETE FROM `phone` WHERE `id` = ?";
	
	/** The delete all phones person. */
	private final String DELETE_ALL_PHONES_PERSON = "DELETE FROM `phone` WHERE `pid` = ?";

	/**
	 * Instantiates a new phone dao.
	 */
	private PhoneDao() {
	}

	/**
	 * Gets the single instance of PhoneDao.
	 *
	 * @return single instance of PhoneDao
	 */
	public static PhoneDao getInstance() {
		if (instance == null)
			instance = new PhoneDao();
		return instance;
	}

	/**
	 * Adds the phone to person.
	 *
	 * @param phone the phone
	 * @param personId the person id
	 */
	@Override
	public void addPhoneToPerson(Phone phone, int personId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(ADD_PHONE_PERSON);
			prepStatement.setInt(1, personId);
			prepStatement.setString(2, phone.getPhone());
			prepStatement.setBoolean(3, phone.isPrimary());
			prepStatement.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Find all phones for person.
	 *
	 * @param personId the person id
	 * @return the collection
	 */
	@Override
	public Collection<Phone> findAllPhonesForPerson(int personId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(FIND_ALL_PHONES_PERSON);
			prepStatement.setInt(1, personId);
			resultSet = prepStatement.executeQuery();

			return Utility.getCollectionOfPhone(resultSet);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Find phone by id.
	 *
	 * @param phoneId the phone id
	 * @return the phone
	 */
	@Override
	public Phone findPhoneById(int phoneId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(FIND_PHONE_BY_ID);
			prepStatement.setInt(1, phoneId);
			resultSet = prepStatement.executeQuery();
			Collection<Phone> phones = Utility.getCollectionOfPhone(resultSet);
			return phones != null && !phones.isEmpty() ? (Phone) phones.toArray()[0] : null;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Update primary phone.
	 *
	 * @param personId the person id
	 * @param phone the phone
	 * @return the int
	 */
	@Override
	public int updatePrimaryPhone(int personId, Phone phone) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(UPDATE_PRIMARY_PHONE);
			prepStatement.setString(1, phone.getPhone());
			prepStatement.setInt(2, personId);
			return prepStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Update phone.
	 *
	 * @param phoneId the phone id
	 * @param phone the phone
	 * @return the int
	 */
	@Override
	public int updatePhone(int phoneId, Phone phone) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(UPDATE_PHONE);
			prepStatement.setString(1, phone.getPhone());
			if (phone.getPerson() != null)
				prepStatement.setInt(2, phone.getPerson().getId());
			prepStatement.setInt(3, phoneId);
			return prepStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Delete phone.
	 *
	 * @param phoneId the phone id
	 * @return the int
	 */
	@Override
	public int deletePhone(int phoneId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(DELETE_PHONE);
			prepStatement.setInt(1, phoneId);
			return prepStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Delete all phones for person.
	 *
	 * @param personId the person id
	 * @return the int
	 */
	@Override
	public int deleteAllPhonesForPerson(int personId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(DELETE_ALL_PHONES_PERSON);
			prepStatement.setInt(1, personId);
			return prepStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
