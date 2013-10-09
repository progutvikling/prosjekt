package gui.admin;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class ManageKeywordsPanel extends JPanel {
	private static final long serialVersionUID = 9035836985008417742L;
	
	public ManageKeywordsPanel() {
		this.setName("Administrer søkeord");
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		
		//
		// Stupid table:
		//
		TableModel model = new AbstractTableModel() {
			private static final long serialVersionUID = -1060196072670653305L;
			public int getColumnCount() { return 2; }
			public String getColumnName(int c) { String[] columns = {"Søkeord", "Delete"};
												 return columns[c]; } 
			public int getRowCount() { return 10; }
			public Object getValueAt(int r, int c) { return new Integer(r*c); }
		};
		JTable table = new JTable(model);
		table.getColumn(table.getColumnName(1)).setCellRenderer(new DeleteColumnCellRenderer());
		JScrollPane scrollPane = new JScrollPane(table);
		this.add(scrollPane);
		

		
		//
		// Stupid add field:
		//
		JPanel hPanel = new JPanel();
		hPanel.setLayout(new BoxLayout(hPanel, BoxLayout.X_AXIS));
		JTextField textField = new JTextField();
		textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, textField.getPreferredSize().height));
		hPanel.add(textField);
		hPanel.add(new JButton("Legg til"));
		this.add(hPanel);
	}
}


class DeleteColumnCellRenderer implements TableCellRenderer {
	private static final long serialVersionUID = 5504457843999031149L;
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		
		JButton btn = new JButton(value.toString());
		return btn;
	}
}

class DeleteColumnCellEditor extends DefaultCellEditor {
	private static final long serialVersionUID = 5642981805026129582L;

	protected JButton button;
	
	private String label;
	
	private boolean isPushed;
	
	public DeleteColumnCellEditor(JCheckBox checkBox) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
	}
}