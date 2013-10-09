package bll.admin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dal.admin.Image;

public class ImageParser {
	
	public static String getJsonFromImage(Image image) {
		Gson gson = new GsonBuilder()
		   .setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		String json = gson.toJson(image);
		return json;
	}
}
