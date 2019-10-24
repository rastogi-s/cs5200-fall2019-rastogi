package edu.northeastern.cs5200.daos;

import java.util.Collection;

import edu.northeastern.cs5200.models.Address;

/**
 * The Interface AddressImpl.
 */
public interface AddressImpl {

	/**
	 * Adds the address to person.
	 *
	 * @param address the address
	 * @param personId the person id
	 */
	void addAddressToPerson(Address address,int personId);

	/**
	 * Find all addresss for person.
	 *
	 * @param personId the person id
	 * @return the collection
	 */
	Collection<Address> findAllAddresssForPerson(int personId);

	/**
	 * Find address by id.
	 *
	 * @param addressId the address id
	 * @return the address
	 */
	Address findAddressById(int addressId);

	/**
	 * Update primary address.
	 *
	 * @param personId the person id
	 * @param address the address
	 * @return the int
	 */
	int updatePrimaryAddress(int personId, Address address);

	/**
	 * Update address.
	 *
	 * @param addressId the address id
	 * @param address the address
	 * @return the int
	 */
	int updateAddress(int addressId, Address address);

	/**
	 * Delete address.
	 *
	 * @param addressId the address id
	 * @return the int
	 */
	int deleteAddress(int addressId);
	
	
	/**
	 * Delete all addressess for person.
	 *
	 * @param personId the person id
	 * @return the int
	 */
	int deleteAllAddressesForPerson(int personId);
}
