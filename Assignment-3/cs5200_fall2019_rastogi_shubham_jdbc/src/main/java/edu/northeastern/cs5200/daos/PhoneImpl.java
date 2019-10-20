package edu.northeastern.cs5200.daos;

import java.util.Collection;

import edu.northeastern.cs5200.models.Phone;

/**
 * The Interface PhoneImpl.
 */
public interface PhoneImpl {

	/**
	 * Adds the phone to person.
	 *
	 * @param person the person
	 */
	void addPhoneToPerson(Phone phone,int personId);

	/**
	 * Find all phones for person.
	 *
	 * @param personId the person id
	 * @return the collection
	 */
	Collection<Phone> findAllPhonesForPerson(int personId);

	/**
	 * Find phone by id.
	 *
	 * @param phoneId the phone id
	 * @return the phone
	 */
	Phone findPhoneById(int phoneId);

	/**
	 * Update primary phone.
	 *
	 * @param personId the person id
	 * @param phone the phone
	 * @return the int
	 */
	int updatePrimaryPhone(int personId, Phone phone);

	/**
	 * Update phone.
	 *
	 * @param phoneId the phone id
	 * @param phone the phone
	 * @return the int
	 */
	int updatePhone(int phoneId, Phone phone);

	/**
	 * Delete phone.
	 *
	 * @param phoneId the phone id
	 * @return the int
	 */
	int deletePhone(int phoneId);
	
	
	/**
	 * Delete all phones for person.
	 *
	 * @param personId the person id
	 * @return the int
	 */
	int deleteAllPhonesForPerson(int personId);
}
