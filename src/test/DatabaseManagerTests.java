package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.hamcrest.CoreMatchers.*;
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
	
	@Test
	public void getLastHundredImagesTest() {
		DatabaseManager dm = new DatabaseManager();
		ArrayList<Image> img = dm.getLast(100);
		assertNotNull(img);
	}
}
