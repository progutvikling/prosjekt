package dal.admin;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * This class is responsible for inserting and retrieving
 * images from our database
 * @author Stian Sandve
 *
 */

public class DatabaseManager {
	
	public static final String QUERY_INSERT_IMAGE = "INSERT INTO images" +
			" (url, external_id, description, created_time)" +
			" VALUES (?, ?, ?, ?);";
	
	public static final String QUERY_GET_LAST_N_IMAGES = "SELECT url, external_id, description, created_time"+
			" FROM images ORDER BY id DESC LIMIT ?;";

	public synchronized boolean insert(Image img) {
		
		PreparedStatement statement;

		String url = img.getUrl();
		int id = img.getID();
		String description = img.getDescription();
		Date createdTime = img.getCreatedTime();

		try (Connection connection = DriverManager.getConnection(Database.DB_URL, Database.DB_USERNAME, Database.DB_PASSWORD)) {

			statement = connection.prepareStatement(QUERY_INSERT_IMAGE);
			statement.setString(1, url);
			statement.setInt(2, id);
			statement.setString(3, description);
			statement.setDate(4, createdTime);
			statement.executeUpdate();
	
			return true;

		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public synchronized ArrayList<Image> getLast(int numberOfRows) {
		
		if(numberOfRows < 0)
			throw new IllegalArgumentException();
		
		PreparedStatement statement;
		ResultSet result;

		ArrayList<Image> images = new ArrayList<Image>();
		String url;
		int id;
		String description;
		Date createdTime;

		try (Connection connection = DriverManager.getConnection(Database.DB_URL, Database.DB_USERNAME, Database.DB_PASSWORD)) {
			statement = connection.prepareStatement(QUERY_GET_LAST_N_IMAGES);
			statement.setInt(1, numberOfRows);
			result = statement.executeQuery();
			while (result.next()) {
				url = result.getString("url");
				id = result.getInt("external_id");
				description = result.getString("description");
				createdTime = result.getDate("created_time");
				images.add(new Image(url, id, description, createdTime));				
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return images;
	}
}
