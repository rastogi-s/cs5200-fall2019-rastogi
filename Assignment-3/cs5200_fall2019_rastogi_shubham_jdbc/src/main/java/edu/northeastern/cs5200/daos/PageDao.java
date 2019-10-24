package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import edu.northeastern.cs5200.Utility;
import edu.northeastern.cs5200.models.Page;

/**
 * The Class PageDao.
 */
public class PageDao implements PageImpl {

	/** The instance. */
	private static PageDao instance;
	
	/** The connection. */
	private Connection connection;
	
	/** The prep statement. */
	private PreparedStatement prepStatement;
	
	/** The result set. */
	private ResultSet resultSet;
	
	/** The create page. */
	private final String CREATE_PAGE = "INSERT INTO `page`(`id`,`title`,`description`,`views`,`created`,`updated`,`wid`) VALUES (?,?,?,?,?,?,?)";
	
	/** The find all pages. */
	private final String FIND_ALL_PAGES = "SELECT *  FROM `page`";
	
	/** The find pages for website. */
	private final String FIND_PAGES_FOR_WEBSITE = "SELECT *  FROM `page` WHERE `wid` = ?";
	
	/** The find page by id. */
	private final String FIND_PAGE_BY_ID = "SELECT *  FROM `page` WHERE `id` = ?";
	
	/** The update page. */
	private final String UPDATE_PAGE = "UPDATE `page` SET `title`= ?,`description` = ?,`views`=?, `created`=?, `updated`=?,`wid`= ?  WHERE `id` = ?";
	
	/** The delete page. */
	private final String DELETE_PAGE = "DELETE FROM `page` WHERE `id` = ?";

	/**
	 * Instantiates a new page dao.
	 */
	private PageDao() {
	}

	/**
	 * Gets the single instance of PageDao.
	 *
	 * @return single instance of PageDao
	 */
	public static PageDao getInstance() {
		if (instance == null)
			instance = new PageDao();
		return instance;
	}

	/**
	 * Creates the page for website.
	 *
	 * @param websiteId the website id
	 * @param page the page
	 */
	@Override
	public void createPageForWebsite(int websiteId, Page page) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(CREATE_PAGE);
			prepStatement.setInt(1, page.getId());
			prepStatement.setString(2, page.getTitle());
			prepStatement.setString(3, page.getDescription());
			prepStatement.setInt(4, page.getViews());
			prepStatement.setDate(5, page.getCreated());
			prepStatement.setDate(6, page.getUpdated());
			prepStatement.setInt(7, websiteId);
			prepStatement.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Find all pages.
	 *
	 * @return the collection
	 */
	@Override
	public Collection<Page> findAllPages() {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(FIND_ALL_PAGES);
			resultSet = prepStatement.executeQuery();

			return Utility.getCollectionOfPages(resultSet);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Find page by id.
	 *
	 * @param pageId the page id
	 * @return the page
	 */
	@Override
	public Page findPageById(int pageId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(FIND_PAGE_BY_ID);
			prepStatement.setInt(1, pageId);
			resultSet = prepStatement.executeQuery();
			Collection<Page> pages = Utility.getCollectionOfPages(resultSet);
			return pages != null && !pages.isEmpty() ? (Page) pages.toArray()[0] : null;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Find pages for website.
	 *
	 * @param websiteId the website id
	 * @return the collection
	 */
	@Override
	public Collection<Page> findPagesForWebsite(int websiteId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(FIND_PAGES_FOR_WEBSITE);
			prepStatement.setInt(1, websiteId);
			resultSet = prepStatement.executeQuery();
			return Utility.getCollectionOfPages(resultSet);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Update page.
	 *
	 * @param pageId the page id
	 * @param page the page
	 * @return the int
	 */
	@Override
	public int updatePage(int pageId, Page page) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(UPDATE_PAGE);
			prepStatement.setString(1, page.getTitle());
			prepStatement.setString(2, page.getDescription());
			prepStatement.setInt(3, page.getViews());
			prepStatement.setDate(4, page.getCreated());
			prepStatement.setDate(5, new Date(System.currentTimeMillis()));
			prepStatement.setInt(6, page.getWebsite().getId());
			prepStatement.setInt(7, pageId);
			return prepStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Delete page.
	 *
	 * @param pageId the page id
	 * @return the int
	 */
	@Override
	public int deletePage(int pageId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(DELETE_PAGE);
			prepStatement.setInt(1, pageId);
			return prepStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
