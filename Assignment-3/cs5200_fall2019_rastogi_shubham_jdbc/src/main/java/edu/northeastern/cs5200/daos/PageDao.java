package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import edu.northeastern.cs5200.Utility;
import edu.northeastern.cs5200.models.Page;

public class PageDao implements PageImpl {

	private static PageDao instance;
	private Connection connection;
	private PreparedStatement prepStatement;
	private ResultSet resultSet;
	private final String CREATE_PAGE = "INSERT INTO `page`(`id`,`title`,`description`,`views`,`created`,`updated`,`wid`) VALUES (?,?,?,?,?,?,?)";
	private final String FIND_ALL_PAGES = "SELECT *  FROM `page`";
	private final String FIND_PAGES_FOR_WEBSITE = "SELECT *  FROM `page` WHERE `wid` = ?";
	private final String FIND_PAGE_BY_ID = "SELECT *  FROM `page` WHERE `id` = ?";
	private final String UPDATE_PAGE = "UPDATE `page` SET `title`= ?,`description` = ?,`views`=?, `created`=?, `updated`=?,`wid`= ?  WHERE `id` = ?";
	private final String DELETE_PAGE = "DELETE FROM `page` WHERE `id` = ?";

	private PageDao() {
	}

	public static PageDao getInstance() {
		if (instance == null)
			instance = new PageDao();
		return instance;
	}

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
