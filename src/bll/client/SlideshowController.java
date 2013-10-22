package bll.client;

import java.io.IOException;

import javax.swing.JPanel;
import gui.client.SlideshowPanel;
import gui.client.SlideshowView;

public class SlideshowController {
	private static SlideshowGetPictures slideshowgetpictures;

	public static void main(String[] args) throws IOException,
			InterruptedException {
		SlideshowPanel slideshowpanel = new SlideshowPanel();
		slideshowgetpictures = new SlideshowGetPictures();

		JPanel panel = new JPanel();
		panel.add(slideshowpanel);

		SlideshowView slideshow = new SlideshowView(panel);
		slideshow.setVisible(true);
		slideshow.setDefaultCloseOperation(SlideshowView.EXIT_ON_CLOSE);

	}

}
