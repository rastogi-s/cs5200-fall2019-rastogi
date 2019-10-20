package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RoleDao implements RoleImpl {

	private static RoleDao instance;
	private Connection connection;
	private PreparedStatement prepStatement;
	private final String ASSIGN_WEBSITE_ROLE = "INSERT INTO `website_role`(`role_id`,`did`,`wid`) VALUES(?,?,?)";
	private final String ASSIGN_PAGE_ROLE = "INSERT INTO `page_role`(`role_id`,`did`,`page_id`) VALUES(?,?,?)";
	private final String DELETE_WEBSITE_ROLE = "DELETE FROM `website_role` WHERE `role_id` = ? AND `did` = ? AND `wid` = ?";
	private final String DELETE_PAGE_ROLE = "DELETE FROM `page_role` WHERE `role_id` = ? AND `did` = ? AND `page_id` = ?";
	private final String DELETE_PAGE_ROLE_FOR_PAGE = "DELETE FROM `page_role` WHERE `page_id` = ?";
	private final String DELETE_WEBSITE_ROLE_FOR_WEBSITE = "DELETE FROM `website_role` WHERE `wid` = ?";
	private final String FIND_PAGE_ROLE_ID_FOR_PAGE_DEVELOPER = "SELECT `role_id` FROM `page_role` WHERE `did` = ? AND `page_id` = ?";
	private final String SWAP_ROLES = "UPDATE `page_role` SET `role_id` = CASE "
			+ " WHEN `did` = ? THEN ? "
			+ "WHEN `did` = ? THEN ? "
			+ "ELSE `role_id` "
			+ "END WHERE `page_id` = ?";
	
	
	private RoleDao() {
	}

	public static RoleDao getInstance() {
		if (instance == null)
			instance = new RoleDao();
		return instance;
	}

	

	@Override
	public void assignWebsiteRole(int developerId, int websiteId, int roleId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(ASSIGN_WEBSITE_ROLE);
			prepStatement.setInt(1, roleId);
			prepStatement.setInt(2, developerId);
			prepStatement.setInt(3, websiteId);
			prepStatement.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void assignPageRole(int developerId, int pageId, int roleId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(ASSIGN_PAGE_ROLE);
			prepStatement.setInt(1, roleId);
			prepStatement.setInt(2, developerId);
			prepStatement.setInt(3, pageId);
			prepStatement.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteWebsiteRole(int developerId, int websiteId, int roleId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(DELETE_WEBSITE_ROLE);
			prepStatement.setInt(1, roleId);
			prepStatement.setInt(2, developerId);
			prepStatement.setInt(3, websiteId);
			prepStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletePageRole(int developerId, int pageId, int roleId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(DELETE_PAGE_ROLE);
			prepStatement.setInt(1, roleId);
			prepStatement.setInt(2, developerId);
			prepStatement.setInt(3, pageId);
			prepStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletePageRoleForPage(int pageId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(DELETE_PAGE_ROLE_FOR_PAGE);
			prepStatement.setInt(1, pageId);
			prepStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteWebisteRoleForWebsite(int websiteId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(DELETE_WEBSITE_ROLE_FOR_WEBSITE);
			prepStatement.setInt(1, websiteId);
			prepStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public int findPageRoleIdWebsiteDeveloper(int pageId,int developerId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(FIND_PAGE_ROLE_ID_FOR_PAGE_DEVELOPER);
			prepStatement.setInt(1, developerId);
			prepStatement.setInt(2, pageId);
			ResultSet resultSet = prepStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getInt("role_id");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}
	
	public void swapRoles(int developerId1,int roleId1,int developerId2,int roleId2, int pageId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			prepStatement = connection.prepareStatement(SWAP_ROLES);
			prepStatement.setInt(1, developerId1);
			prepStatement.setInt(2, roleId2);
			prepStatement.setInt(3, developerId2);
			prepStatement.setInt(4, roleId1);
			prepStatement.setInt(5, pageId);
			prepStatement.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
