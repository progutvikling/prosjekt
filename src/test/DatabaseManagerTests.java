package test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import dal.DatabaseManager;
import dal.Image;

public class DatabaseManagerTests {
	
	@Test
	public void insertTest() {
		DatabaseManager dm = new DatabaseManager();
		Image img = new Image("insertUrl", 1234, "insertTest");
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
