package bll.admin;

import gui.admin.MainWindow;
import gui.admin.ManageConfigsPanel;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * This class sets up the main window with all its tabs.
 * Add lines to this class when adding more admin panels!
 */
public class AdminMainController {
	public static void main(String[] args) {
		ManageKeywordsController manageKeywords = new ManageKeywordsController();
		
		ArrayList<JPanel> panels = new ArrayList<JPanel>();
		panels.add(manageKeywords.getView());
		panels.add(new ManageConfigsPanel());
		
		MainWindow wnd = new MainWindow(panels);
		wnd.setVisible(true);
		wnd.setDefaultCloseOperation(MainWindow.EXIT_ON_CLOSE);
	}
}
