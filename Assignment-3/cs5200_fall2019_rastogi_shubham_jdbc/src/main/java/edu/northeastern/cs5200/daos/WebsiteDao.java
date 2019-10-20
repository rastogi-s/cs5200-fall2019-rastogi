package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import edu.northeastern.cs5200.Utility;
import edu.northeastern.cs5200.models.Website;

public class WebsiteDao implements WebsiteImpl {

	private static WebsiteDao instance;
	private Connection connection;
	private PreparedStatement prepStatement;
	private ResultSet resultSet;
	private final String CREATE_WEBSITE = "INSERT INTO `website`(`id`,`name`,`description`,`visits`,`created`,`updated`,`creator_id`) VALUES (?,?,?,?,?,?,?)";
	private final String FIND_ALL_WEBSITE = "SELECT *  FROM `website`";
	private final String FIND_WEBSITE_BY_DEVELOPER_ID = "SELECT *  FROM `website` WHERE `creator_id` = ?";
	private final String FIND_WEBSITE_BY_ID = "SELECT *  FROM `website` WHERE `id` = ?";
	private final String UPDATE_WEBSITE = "UPDATE `website` SET `name`= ?,`description` = ?,`visits`=?, `created`=?, `updated`=?, `creator_id`=?  WHERE `id` = ?";
	private final String DELETE_WEBSITE = "DELETE FROM `website` WHERE `id` = ?";
	
	private WebsiteDao() {
	}

	public static WebsiteDao getInstance() {
		if (instance == null)
			instance = new WebsiteDao();
		return instance;
	}

	@Override
	public void createWebsiteForDeveloper(int developerId, Website website) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(CREATE_WEBSITE);
			prepStatement.setInt(1, website.getId());
			prepStatement.setString(2, website.getName());
			prepStatement.setString(3, website.getDescription());
			prepStatement.setInt(4, website.getVisits());
			prepStatement.setDate(5, website.getCreated());
			prepStatement.setDate(6, website.getUpdated());
			prepStatement.setInt(7, developerId);
			prepStatement.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Collection<Website> findAllWebsites() {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(FIND_ALL_WEBSITE);
			resultSet = prepStatement.executeQuery();

			return Utility.getCollectionOfWebsites(resultSet);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Collection<Website> findWebsitesForDeveloper(int developerId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(FIND_WEBSITE_BY_DEVELOPER_ID);
			prepStatement.setInt(1, developerId);
			resultSet = prepStatement.executeQuery();
			return Utility.getCollectionOfWebsites(resultSet);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Website findWebsiteById(int websiteId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(FIND_WEBSITE_BY_ID);
			prepStatement.setInt(1, websiteId);
			resultSet = prepStatement.executeQuery();
			Collection<Website> websites = Utility.getCollectionOfWebsites(resultSet);
			return websites != null && !websites.isEmpty() ? (Website) websites.toArray()[0] : null;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int updateWebsite(int websiteId, Website website) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(UPDATE_WEBSITE);
			prepStatement.setString(1, website.getName());
			prepStatement.setString(2, website.getDescription());
			prepStatement.setInt(3, website.getVisits());
			prepStatement.setDate(4, website.getCreated());
			prepStatement.setDate(5, new Date(System.currentTimeMillis()));
			prepStatement.setInt(6, website.getCreator().getId());
			prepStatement.setInt(7, websiteId);
			return prepStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteWebsite(int websiteId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(DELETE_WEBSITE);
			prepStatement.setInt(1, websiteId);
			return prepStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	

}
