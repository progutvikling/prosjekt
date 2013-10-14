package dal.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * This is the place to store database related constants
 * @author Stian Sandve
 *
 */

public class Database {
	public static final String DB_URL = "jdbc:mysql://localhost/PictureBrowser";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(Database.DB_URL, Database.DB_USERNAME, Database.DB_PASSWORD);
	}
}
