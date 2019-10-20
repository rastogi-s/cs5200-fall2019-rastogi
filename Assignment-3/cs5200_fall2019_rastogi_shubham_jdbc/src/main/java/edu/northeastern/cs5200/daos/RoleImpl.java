package edu.northeastern.cs5200.daos;

/**
 * The Interface RoleImpl.
 */
public interface RoleImpl {

	/**
	 * Assign website role. Inserts into table Role a record that assigns a
	 * developer whose id is developerId, the role with roleId, to the website with
	 * websiteId
	 *
	 * 
	 * @param developerId the developer id
	 * @param websiteId   the website id
	 * @param roleId      the role id
	 */
	void assignWebsiteRole(int developerId, int websiteId, int roleId);

	/**
	 * Assign page role. Inserts into table Role a record that assigns a developer
	 * whose id is developerId, the role with roleId, to the page with pageId
	 *
	 * 
	 * @param developerId the developer id
	 * @param pageId      the page id
	 * @param roleId      the role id
	 */
	void assignPageRole(int developerId, int pageId, int roleId);

	/**
	 * Delete website role. Deletes from table Role a record that removes roleId
	 * from developerId, on websiteId
	 *
	 * 
	 * @param developerId the developer id
	 * @param websiteId   the website id
	 * @param roleId      the role id
	 */
	void deleteWebsiteRole(int developerId, int websiteId, int roleId);

	/**
	 * Delete page role. Deletes from table Role a record that removes roleId from
	 * developerId, on pageId
	 *
	 * @param developerId the developer id
	 * @param pageId      the page id
	 * @param roleId      the role id
	 */
	void deletePageRole(int developerId, int pageId, int roleId);

}
