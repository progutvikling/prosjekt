package test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Test;

import bll.admin.ImageParser;

import dal.admin.Image;

public class ImageParserTest {
	
	@Test
	public void givenImageCeckThatReturnedJsonIsValid() {
		Date sqlDate = new Date(0);
		Image img = new Image("url", 1, "description", sqlDate);
		String json = ImageParser.getJsonFromImage(img);
		//has to be 1970-01-01 01:00:00 because the program will detect the time zone
		//that our jvm is set to (which is GMT+1)
		assertEquals(json, "{\"url\":\"url\",\"id\":1,\"description\":" +
				"\"description\",\"createdTime\":\"1970-01-01 01:00:00\"}");
	}
	
	@Test
	public void givenArrayListOfImagesCeckThatReturnedJsonIsValid() {
		Date sqlDate1 = new Date(0);
		Image img1 = new Image("url1", 1, "description1", sqlDate1);
		
		Date sqlDate2 = new Date(1000);
		Image img2 = new Image("url2", 2, "description2", sqlDate2);
		
		ArrayList<Image> images = new ArrayList<Image>();
		images.add(img1);
		images.add(img2);
		
		String json = ImageParser.getJsonFromImage(images);
		//has to be 1970-01-01 01:00:00 because the program will detect the time zone
		//that our jvm is set to (which is GMT+1)
		assertEquals(json, "[{\"url\":\"url1\",\"id\":1,\"description\":" +
				"\"description1\",\"createdTime\":\"1970-01-01 01:00:00\"}" + 
				",{\"url\":\"url2\",\"id\":2,\"description\":" +
						"\"description2\",\"createdTime\":\"1970-01-01 01:00:01\"}]");
	}
}
