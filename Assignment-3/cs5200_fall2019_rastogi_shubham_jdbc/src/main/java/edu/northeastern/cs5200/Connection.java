package edu.northeastern.cs5200;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Class Connection.
 */
public class Connection {

	/** The Constant DRIVER. */
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	/** The Constant URL. */
	private static final String URL = "jdbc:mysql://cs5200-fall2019-rastogi.caobcohwr5ry.us-east-1.rds.amazonaws.com/cs5200_fall2019_rastogi-assign3";
	// private static final String URL = "jdbc:mysql://localhost/cs5200_fall2019_rastogi-assign3";
	
	
	/** The Constant USER. */
	private static final String USER = "admin";
	//private static final String USER = "root";
	
	/** The Constant PASSWORD. */
	private static final String PASSWORD = "rastogis";
	// private static final String PASSWORD = "root";
	
	/** The db connection. */
	private static java.sql.Connection dbConnection = null;

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public static java.sql.Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);

		if (dbConnection == null) {
			dbConnection = DriverManager.getConnection(URL, USER, PASSWORD);
			return dbConnection;
		} else {
			return dbConnection;
		}
	}

	/**
	 * Close connection.
	 */
	public static void closeConnection() {
		try {
			if (dbConnection != null) {
				dbConnection.close();
				dbConnection = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
