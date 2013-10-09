package test;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import bll.admin.ImageParser;

import dal.admin.Image;

public class ImageParserTest {
	
	@Test
	public void givenImageCeckThatReturnedJsonIsValid() {
		Date sqlDate = new Date(0);
		String date = sqlDate.toString();
		Image img = new Image("url", 1, "description", sqlDate);
		String json = ImageParser.getJsonFromImage(img);
		System.out.println(date);
		System.out.println(json);
		//have to be 1970-01-01 01:00:00 because the program will detect the that zone
		//that our jvm is set to (which is GMT+1)
		assertEquals(json, "{\"url\":\"url\",\"id\":1,\"description\":\"description\",\"createdTime\":\"1970-01-01 01:00:00\"}");
	}
}
