package edu.northeastern.cs5200.daos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.northeastern.cs5200.models.Person;
import edu.northeastern.cs5200.repositories.PersonRepository;

/**
 * The Class PersonDao.
 */
@Repository
public class PersonDao {

	/** The person repository. */
	@Autowired
	private PersonRepository personRepository;

	/**
	 * Find all users.
	 *
	 * @return the list
	 */
	public List<Person> findAllUsers() {
		Iterable<Person> iter = personRepository.findAll();
		List<Person> listOfPerson = new ArrayList<>();
		for (Person person : iter) {
			listOfPerson.add(person);
		}

		return listOfPerson;
	}

}
