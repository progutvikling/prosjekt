package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseManager {

	public boolean insert(Image img) {
		
		PreparedStatement statement;

		String url = img.getUrl();
		int id = img.getID();
		String description = img.getDescription();
		Date createdTime = img.getCreatedTime();

		try (Connection connection = DriverManager.getConnection(Database.DB_URL, Database.DB_USERNAME, Database.DB_PASSWORD)) {

			statement = connection.prepareStatement(Database.QUERY_INSERT_IMAGE);
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
	
	
	public ArrayList<Image> getLast(int numberOfRows) {
		
		PreparedStatement statement;
		ResultSet result;

		ArrayList<Image> images = new ArrayList<Image>();
		String url;
		int id;
		String description;
		Date createdTime;

		try (Connection connection = DriverManager.getConnection(Database.DB_URL, Database.DB_USERNAME, Database.DB_PASSWORD)) {
			statement = connection.prepareStatement(Database.QUERY_GET_LAST_N_IMAGES);
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
