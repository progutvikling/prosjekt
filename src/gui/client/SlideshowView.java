package gui.client;

import java.awt.BorderLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SlideshowView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6617699591663763458L;
	public static GraphicsDevice devise = GraphicsEnvironment
			.getLocalGraphicsEnvironment().getScreenDevices()[0];

	public SlideshowView(JPanel viewPanel) {
		this.setSize(600, 600);
		devise.setFullScreenWindow(this);
		this.setTitle("PcitureBrowser");
		this.setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.add(viewPanel);
		this.add(panel, BorderLayout.CENTER);

	}

}
