package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * The Class PriviledgeDao.
 */
public class PriviledgeDao implements PrivilegeImpl {
	
	/** The instance. */
	private static PriviledgeDao instance;
	
	/** The connection. */
	private Connection connection;
	
	/** The prep statement. */
	private PreparedStatement prepStatement;
	
	/** The assign website priviledge. */
	private final String ASSIGN_WEBSITE_PRIVILEDGE = "INSERT INTO `website_priviledge`(`priviledge`,`did`,`wid`) VALUES(?,?,?)";
	
	/** The assign page priviledge. */
	private final String ASSIGN_PAGE_PRIVILEDGE = "INSERT INTO `page_priviledge`(`priviledge`,`did`,`page_id`) VALUES(?,?,?)";
	
	/** The delete website priviledge. */
	private final String DELETE_WEBSITE_PRIVILEDGE = "DELETE FROM `website_priviledge` WHERE `priviledge` = ? AND `did` = ? AND `wid` = ?";
	
	/** The delete page priviledge. */
	private final String DELETE_PAGE_PRIVILEDGE = "DELETE FROM `page_priviledge` WHERE `priviledge` = ? AND `did` = ? AND `page_id` = ?";
	
	/** The delete website priviledge for website. */
	private final String DELETE_WEBSITE_PRIVILEDGE_FOR_WEBSITE = "DELETE FROM `website_priviledge` WHERE `wid` = ?";
	
	/** The delete page priviledge for page. */
	private final String DELETE_PAGE_PRIVILEDGE_FOR_PAGE = "DELETE FROM `page_priviledge` WHERE `page_id` = ?";

	/**
	 * Instantiates a new priviledge dao.
	 */
	private PriviledgeDao() {
	}

	/**
	 * Gets the single instance of PriviledgeDao.
	 *
	 * @return single instance of PriviledgeDao
	 */
	public static PriviledgeDao getInstance() {
		if (instance == null)
			instance = new PriviledgeDao();
		return instance;
	}

	/**
	 * Assign website priviledge.
	 *
	 * @param developerId the developer id
	 * @param websiteId the website id
	 * @param priviledge the priviledge
	 */
	@Override
	public void assignWebsitePriviledge(int developerId, int websiteId, String priviledge) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(ASSIGN_WEBSITE_PRIVILEDGE);
			prepStatement.setString(1, priviledge);
			prepStatement.setInt(2, developerId);
			prepStatement.setInt(3, websiteId);
			prepStatement.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Assign page priviledge.
	 *
	 * @param developerId the developer id
	 * @param pageId the page id
	 * @param priviledge the priviledge
	 */
	@Override
	public void assignPagePriviledge(int developerId, int pageId, String priviledge) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(ASSIGN_PAGE_PRIVILEDGE);
			prepStatement.setString(1, priviledge);
			prepStatement.setInt(2, developerId);
			prepStatement.setInt(3, pageId);
			prepStatement.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Delete website priviledge.
	 *
	 * @param developerId the developer id
	 * @param websiteId the website id
	 * @param priviledge the priviledge
	 */
	@Override
	public void deleteWebsitePriviledge(int developerId, int websiteId, String priviledge) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(DELETE_WEBSITE_PRIVILEDGE);
			prepStatement.setString(1, priviledge);
			prepStatement.setInt(2, developerId);
			prepStatement.setInt(3, websiteId);
			prepStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Delete page priviledge.
	 *
	 * @param developerId the developer id
	 * @param pageId the page id
	 * @param priviledge the priviledge
	 */
	@Override
	public void deletePagePriviledge(int developerId, int pageId, String priviledge) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(DELETE_PAGE_PRIVILEDGE);
			prepStatement.setString(1, priviledge);
			prepStatement.setInt(2, developerId);
			prepStatement.setInt(3, pageId);
			prepStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Delete website priviledge for webiste.
	 *
	 * @param websiteId the website id
	 */
	public void deleteWebsitePriviledgeForWebiste( int websiteId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(DELETE_WEBSITE_PRIVILEDGE_FOR_WEBSITE);
			prepStatement.setInt(1, websiteId);
			prepStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Delete page priviledge for page.
	 *
	 * @param pageId the page id
	 */
	public void deletePagePriviledgeForPage(int pageId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(DELETE_PAGE_PRIVILEDGE_FOR_PAGE);
			prepStatement.setInt(1, pageId);
			prepStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
