package edu.northeastern.cs5200.daos;

/**
 * The Interface PrivilegeImpl.
 */
public interface PrivilegeImpl {

	/**
	 * Assign website priviledge. Inserts into table Priviledge a record that
	 * assigns a developer whose id is developerId, the priviledge with priviledge
	 * name, to the website with websiteId
	 *
	 * @param developerId the developer id
	 * @param websiteId   the website id
	 * @param priviledge  the priviledge
	 */
	void assignWebsitePriviledge(int developerId, int websiteId, String priviledge);

	/**
	 * Assign page priviledge. Inserts into table Priviledge a record that assigns a
	 * developer whose id is developerId, the priviledge with priviledge name, to
	 * the page with pageId
	 *
	 * @param developerId the developer id
	 * @param pageId      the page id
	 * @param priviledge  the priviledge
	 */
	void assignPagePriviledge(int developerId, int pageId, String priviledge);

	/**
	 * Delete website priviledge. Deletes from table Priviledge a record that
	 * removes priviledge name from developerId, on websiteId
	 * 
	 * @param developerId the developer id
	 * @param websiteId   the website id
	 * @param priviledge  the priviledge
	 */
	void deleteWebsitePriviledge(int developerId, int websiteId, String priviledge);

	/**
	 * Delete page priviledge. deletes from table priviledge a record that removes
	 * priviledge name from developerId, on pageId
	 *
	 * @param developerId the developer id
	 * @param pageId      the page id
	 * @param priviledge  the priviledge
	 */
	void deletePagePriviledge(int developerId, int pageId, String priviledge);

}
