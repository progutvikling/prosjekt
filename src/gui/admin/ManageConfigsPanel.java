package gui.admin;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class ManageConfigsPanel extends JPanel {
	private static final long serialVersionUID = -6769963790859811312L;
	
	private static final int DELAY_MIN = 1;
	private static final int DELAY_MAX = 10;
	private static final int DELAY_INIT = 5;
	
	private JSlider slideshowDelay;
	
	ManageConfigsPanelHandler handler;

	public ManageConfigsPanel(ManageConfigsPanelHandler handler) {
		this.handler = handler;
		
		this.setName("Instillinger");
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
 
        //Create the label.
        JLabel sliderLabel = new JLabel("Slideshow delay", JLabel.CENTER);
        sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new SaveListener(this));
 
        //Create the slider.
        slideshowDelay = new JSlider(JSlider.HORIZONTAL,
                                              DELAY_MIN, DELAY_MAX, DELAY_INIT);
         
 
        //Turn on labels at major tick marks.
 
        slideshowDelay.setMajorTickSpacing(1);
        slideshowDelay.setMinorTickSpacing(1);
        slideshowDelay.setPaintTicks(true);
        slideshowDelay.setPaintLabels(true);
        slideshowDelay.setSnapToTicks(true);
        slideshowDelay.setBorder(
                BorderFactory.createEmptyBorder(0,0,10,0));
        Font font = new Font("Serif", Font.ITALIC, 15);
        slideshowDelay.setFont(font);
        
        add(sliderLabel);
        add(slideshowDelay);
        add(saveButton);
	}
	
	/**
	 * Changelistener for the "Slideshow delay" slider
	 */
	private class SaveListener implements ActionListener {
		private ManageConfigsPanel view;

		public SaveListener(ManageConfigsPanel view) {
			this.view = view;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String delay = Integer.toString(view.slideshowDelay.getValue());
			view.handler.addConfig("slideshow_delay", delay);
		}
	}
}