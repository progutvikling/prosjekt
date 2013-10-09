package bll.admin;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dal.admin.Image;

/**
 * 
 * A utility to get a JSON representation of 
 * dal.admin.Image objects
 * @author Stian Sandve
 *
 */

public class ImageParser {
	
	private static final String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";
	
	public static String getJsonFromImage(Image image) {
		Gson gson = new GsonBuilder()
		   .setDateFormat(DATE_FORMAT).create();
		String json = gson.toJson(image);
		return json;
	}
	
	public static String getJsonFromImage(ArrayList<Image> images) {
		Gson gson = new GsonBuilder()
		   .setDateFormat(DATE_FORMAT).create();
		String json = gson.toJson(images);
		return json;
	}
}
