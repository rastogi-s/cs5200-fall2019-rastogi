package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import edu.northeastern.cs5200.Utility;
import edu.northeastern.cs5200.models.Address;

/**
 * The Class AddressDao.
 */
public class AddressDao implements AddressImpl {

	/** The instance. */
	private static AddressDao instance;
	
	/** The connection. */
	private Connection connection;
	
	/** The prep statement. */
	private PreparedStatement prepStatement;
	
	/** The result set. */
	private ResultSet resultSet;
	
	/** The add address person. */
	private final String ADD_ADDRESS_PERSON = "INSERT INTO `address`(`pid`,`street1`,`street2`,`city`,`state`,`zip`,`primary`) VALUES(?,?,?,?,?,?,?)";
	
	/** The find all addresses person. */
	private final String FIND_ALL_ADDRESSES_PERSON = "SELECT * FROM `address` WHERE `pid` = ?";
	
	/** The find address by id. */
	private final String FIND_ADDRESS_BY_ID = "SELECT * FROM `address` WHERE `id` = ?";
	
	/** The update primary address. */
	private final String UPDATE_PRIMARY_ADDRESS = "UPDATE `address` SET `street1` = ?,`street2` = ?,`city` = ?,`state` = ?,`zip` = ? WHERE `pid` = ? AND `primary` = 'true'";
	
	/** The update address. */
	private final String UPDATE_ADDRESS = "UPDATE `address` SET `street1` = ?,`street2` = ?,`city` = ?,`state` = ?,`zip` = ?,`pid` = ? WHERE `id` = ? ";
	
	/** The delete address. */
	private final String DELETE_ADDRESS = "DELETE FROM `address` WHERE `id` = ?";
	
	/** The delete all addresses person. */
	private final String DELETE_ALL_ADDRESSES_PERSON = "DELETE FROM `address` WHERE `pid` = ?";

	/**
	 * Instantiates a new address dao.
	 */
	private AddressDao() {
	}

	/**
	 * Gets the single instance of AddressDao.
	 *
	 * @return single instance of AddressDao
	 */
	public static AddressDao getInstance() {
		if (instance == null)
			instance = new AddressDao();
		return instance;
	}

	/**
	 * Adds the address to person.
	 *
	 * @param address the address
	 * @param personId the person id
	 */
	@Override
	public void addAddressToPerson(Address address, int personId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(ADD_ADDRESS_PERSON);
			prepStatement.setInt(1, personId);
			prepStatement.setString(2, address.getStreet1());
			prepStatement.setString(3, address.getStreet2());
			prepStatement.setString(4, address.getCity());
			prepStatement.setString(5, address.getState());
			prepStatement.setString(6, address.getZip());
			prepStatement.setBoolean(7, address.isPrimary());
			prepStatement.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Find all addresss for person.
	 *
	 * @param personId the person id
	 * @return the collection
	 */
	@Override
	public Collection<Address> findAllAddresssForPerson(int personId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(FIND_ALL_ADDRESSES_PERSON);
			prepStatement.setInt(1, personId);
			resultSet = prepStatement.executeQuery();

			return Utility.getCollectionOfAddress(resultSet);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Find address by id.
	 *
	 * @param addressId the address id
	 * @return the address
	 */
	@Override
	public Address findAddressById(int addressId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(FIND_ADDRESS_BY_ID);
			prepStatement.setInt(1, addressId);
			resultSet = prepStatement.executeQuery();
			Collection<Address> addresss = Utility.getCollectionOfAddress(resultSet);
			return addresss != null && !addresss.isEmpty() ? (Address) addresss.toArray()[0] : null;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Update primary address.
	 *
	 * @param personId the person id
	 * @param address the address
	 * @return the int
	 */
	@Override
	public int updatePrimaryAddress(int personId, Address address) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(UPDATE_PRIMARY_ADDRESS);
			prepStatement.setString(1, address.getStreet1());
			prepStatement.setString(2, address.getStreet2());
			prepStatement.setString(3, address.getCity());
			prepStatement.setString(4, address.getState());
			prepStatement.setString(5, address.getZip());
			prepStatement.setInt(6, personId);
			return prepStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Update address.
	 *
	 * @param addressId the address id
	 * @param address the address
	 * @return the int
	 */
	@Override
	public int updateAddress(int addressId, Address address) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(UPDATE_ADDRESS);
			prepStatement.setString(1, address.getStreet1());
			prepStatement.setString(2, address.getStreet2());
			prepStatement.setString(3, address.getCity());
			prepStatement.setString(4, address.getState());
			prepStatement.setString(5, address.getZip());
			if (address.getPerson() != null)
				prepStatement.setInt(6, address.getPerson().getId());
			prepStatement.setInt(7, addressId);
			return prepStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Delete address.
	 *
	 * @param addressId the address id
	 * @return the int
	 */
	@Override
	public int deleteAddress(int addressId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(DELETE_ADDRESS);
			prepStatement.setInt(1, addressId);
			return prepStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Delete all addresses for person.
	 *
	 * @param personId the person id
	 * @return the int
	 */
	@Override
	public int deleteAllAddressesForPerson(int personId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(DELETE_ALL_ADDRESSES_PERSON);
			prepStatement.setInt(1, personId);
			return prepStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
