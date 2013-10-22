package bll.client;

import gui.client.SlideshowPanel;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import bll.utils.ImageParser;
import dal.admin.Image;
import dal.client.ImageClient;

public class SlideshowGetPictures {
	private URL url, Testurl;
	private BufferedImage bufferedimage, nextpicture;
	private SlideshowPanel slideshowpanel;
	private ArrayList<Image> images;
	private int i = 0;
	private int Delay = 3000;
	private Image img;
	private String stringurl;

	public SlideshowGetPictures() throws InterruptedException, IOException {
		slideshowpanel = new SlideshowPanel(); // draw pictures
		 getLatestArrayListOfPictures();

		 do {

		/**
		 * Ikke riktig test Får ikke ut bilde enda
		 *

		Testurl = new URL(
				"http://download.4-designer.com/files/2012120505/Vector-modern-abstract-background-05-vector-material-4958.jpg");
		BufferedImage Testimage = ImageIO.read(Testurl);
		DisplayImage(Testimage);*/

		/**
		 * Veldig usikker på hvordan hente nest bilde.
		 */ 
		 bufferedimage = loadPicture(i); 
		 DisplayImage(bufferedimage);
		 nextpicture = loadPicture(i + 1); 
		 bufferedimage=nextpicture; i++;
		  
		  CheckCount(); 
		  //Fins nok en bedre metode på å endre hvor lenge et bilde viser.
		  Thread.sleep(Delay);
		 
		 } while (images != null);
	}

	public void getLatestArrayListOfPictures() {
		String json = ImageClient.fetchImagesFromServer();// Gets
															// response=in.readLine()
		images = ImageParser.getImageFromJson(json);// Sets string json from
													// mysql
	}

	public BufferedImage loadPicture(int i) throws IOException {
		img = images.get(i);
		stringurl = img.getUrl();
		url = new URL(stringurl);
		bufferedimage = ImageIO.read(url);
		return bufferedimage;
	}

	public void DisplayImage(BufferedImage image) {
		slideshowpanel.setImage(image);
	}

	// Reset after 100 pictures
	public void CheckCount() {
		if (i == 100) {
			i = 0;
			getLatestArrayListOfPictures();
		}
	}

	// Time of each picture
	public void setDelay(int i) {
		Delay = i;
	}

}
