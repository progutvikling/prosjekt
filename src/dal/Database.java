package dal;

public class Database {
	public static final String DB_URL = "jdbc:mysql://localhost/PictureBrowser";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "";
	
	public static final String QUERY_INSERT_IMAGE = "INSERT INTO images" +
			" (url, external_id, description)" +
			" VALUES (?, ?, ?);";
	
	public static final String QUERY_GET_LAST_N_IMAGES = "SELECT url, external_id, description"+
			" FROM images ORDER BY id DESC LIMIT ?;";
}
