package edu.northeastern.cs5200.daos;

import java.util.Collection;

import edu.northeastern.cs5200.models.Website;

/**
 * The Interface WebsiteImpl.
 */
public interface WebsiteImpl {

	/**
	 * Creates the website for developer. Inserts properties in website instance
	 * parameter into the Website table. The website's developerId foreign key refer
	 * to Developer table primary key id whose value is equal to the developerId
	 * parameter. You can use the owner's user id as the foreign key
	 *
	 * 
	 * @param developerId the developer id
	 * @param website     the website
	 */
	void createWebsiteForDeveloper(int developerId, Website website);

	/**
	 * Find all websites. Returns all records from Website table as a Collection of
	 * Website instances
	 * 
	 * @return the collection
	 */
	Collection<Website> findAllWebsites();

	/**
	 * Find websites for developer. Returns all records from Website table as a
	 * Collection of Website instances whose developerId is equal to the developerId
	 * parameter
	 *
	 * 
	 * @param developerId the developer id
	 * @return the collection
	 */
	Collection<Website> findWebsitesForDeveloper(int developerId);

	/**
	 * Find website by id. Returns a record from Website table whose id field is
	 * equal to the websiteId parameter
	 *
	 * 
	 * @param websiteId the website id
	 * @return the website
	 */
	Website findWebsiteById(int websiteId);

	/**
	 * Update website. Updates record in Website table whose id field is equal to
	 * websiteId parameter. New record field values are set to the values in the
	 * website instance parameter
	 *
	 * 
	 * @param websiteId the website id
	 * @param website   the website
	 * @return the int
	 */
	int updateWebsite(int websiteId, Website website);

	/**
	 * Delete website. Deletes record from Website table whose id field is equal to
	 * websiteId parameter
	 *
	 * @param websiteId the website id
	 * @return the int
	 */
	int deleteWebsite(int websiteId);

}
