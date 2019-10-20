package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import edu.northeastern.cs5200.Utility;
import edu.northeastern.cs5200.models.Phone;


public class PhoneDao implements PhoneImpl {

	private static PhoneDao instance;
	private Connection connection;
	private PreparedStatement prepStatement;
	private ResultSet resultSet;
	private final String ADD_PHONE_PERSON = "INSERT INTO `phone`(`pid`,`phone`,`primary`) VALUES(?,?,?)";
	private final String FIND_ALL_PHONES_PERSON = "SELECT * FROM `phone` WHERE `pid` = ?";
	private final String FIND_PHONE_BY_ID = "SELECT * FROM `phone` WHERE `id` = ?";
	private final String UPDATE_PRIMARY_PHONE = "UPDATE `phone` SET `phone` = ? WHERE `pid` = ? AND `primary` = 1";
	private final String UPDATE_PHONE = "UPDATE `phone` SET `phone` = ?,`pid` = ? WHERE `id` = ? ";
	private final String DELETE_PHONE = "DELETE FROM `phone` WHERE `id` = ?";
	private final String DELETE_ALL_PHONES_PERSON = "DELETE FROM `phone` WHERE `pid` = ?";

	private PhoneDao() {
	}

	public static PhoneDao getInstance() {
		if (instance == null)
			instance = new PhoneDao();
		return instance;
	}

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
