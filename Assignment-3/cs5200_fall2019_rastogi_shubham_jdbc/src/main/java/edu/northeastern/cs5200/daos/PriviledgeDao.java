package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PriviledgeDao implements PrivilegeImpl {
	
	private static PriviledgeDao instance;
	private Connection connection;
	private PreparedStatement prepStatement;
	private final String ASSIGN_WEBSITE_PRIVILEDGE = "INSERT INTO `website_priviledge`(`priviledge`,`did`,`wid`) VALUES(?,?,?)";
	private final String ASSIGN_PAGE_PRIVILEDGE = "INSERT INTO `page_priviledge`(`priviledge`,`did`,`page_id`) VALUES(?,?,?)";
	private final String DELETE_WEBSITE_PRIVILEDGE = "DELETE FROM `website_priviledge` WHERE `priviledge` = ? AND `did` = ? AND `wid` = ?";
	private final String DELETE_PAGE_PRIVILEDGE = "DELETE FROM `page_priviledge` WHERE `priviledge` = ? AND `did` = ? AND `page_id` = ?";
	private final String DELETE_WEBSITE_PRIVILEDGE_FOR_WEBSITE = "DELETE FROM `website_priviledge` WHERE `wid` = ?";
	private final String DELETE_PAGE_PRIVILEDGE_FOR_PAGE = "DELETE FROM `page_priviledge` WHERE `page_id` = ?";

	private PriviledgeDao() {
	}

	public static PriviledgeDao getInstance() {
		if (instance == null)
			instance = new PriviledgeDao();
		return instance;
	}

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
