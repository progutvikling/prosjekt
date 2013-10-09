package gui.admin;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	
	public MainWindow(List<JPanel> adminPanels) {
		this.setSize(600, 600);
		this.setLayout(new BorderLayout());
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		for (JPanel p : adminPanels) {
			tabbedPane.add(p);
		}
		
		this.add(tabbedPane, BorderLayout.CENTER);
	}
}
