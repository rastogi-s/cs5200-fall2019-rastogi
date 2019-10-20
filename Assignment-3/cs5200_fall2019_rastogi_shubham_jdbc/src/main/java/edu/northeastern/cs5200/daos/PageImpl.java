package edu.northeastern.cs5200.daos;

import java.util.Collection;

import edu.northeastern.cs5200.models.Page;

/**
 * The Interface PageImpl.
 */
public interface PageImpl {

	/**
	 * Creates the page for website. Inserts properties in page instance parameter
	 * into the Page table. The page's websiteId foreign key refer to Website table
	 * primary key id whose value is equal to the websiteId parameter
	 *
	 * 
	 * @param websiteId the website id
	 * @param page      the page
	 */
	void createPageForWebsite(int websiteId, Page page);

	/**
	 * Find all pages. Returns all records from Page table as a Collection of Page
	 * instances
	 *
	 * 
	 * @return the collection
	 */
	Collection<Page> findAllPages();

	/**
	 * Find page by id. Returns a record from Page table whose id field is equal to
	 * the pageId parameter
	 *
	 * 
	 * @param pageId the page id
	 * @return the page
	 */
	Page findPageById(int pageId);

	/**
	 * Find pages for website. Returns all records from Page table as a Collection
	 * of Page instances whose websiteId is equal to the websiteId parameter
	 *
	 * 
	 * @param websiteId the website id
	 * @return the collection
	 */
	Collection<Page> findPagesForWebsite(int websiteId);

	/**
	 * Update page. Updates record in Page table whose id field is equal to pageId
	 * parameter. New record field values are set to the values in the page instance
	 * parameter
	 *
	 * 
	 * @param pageId the page id
	 * @param page   the page
	 * @return the int
	 */
	int updatePage(int pageId, Page page);

	/**
	 * Delete page. Deletes record from Page table whose id field is equal to pageId
	 * parameter
	 *
	 * @param pageId the page id
	 * @return the int
	 */
	int deletePage(int pageId);

}
