package test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import dal.admin.DatabaseManager;
import dal.admin.Image;

/**
 * 
 * An integration test for our database operations
 * @author Stian Sandve
 *
 */

public class DatabaseManagerTests {
	
	DatabaseManager dm;
	
	@Before
	public void initDatabaseConnection() {
		dm = new DatabaseManager();
	}
	
	@Test
	public void insertTest() {
		java.util.Date currentTime = new java.util.Date();
		Image img = new Image("insertUrl", 1234, "insertTest", new Date(currentTime.getTime()));
		boolean succeeded = dm.insert(img);
		assertTrue(succeeded);
	}
	
	//probably a bad idea to have two asserts in the same test,
	//but it will work for now
	@Test
	public void getLastHundredImagesTest() {
		DatabaseManager dm = new DatabaseManager();
		ArrayList<Image> images = dm.getLast(100);
		assertNotNull(images);
		assertTrue(images.size() <= 100);
	}
}
