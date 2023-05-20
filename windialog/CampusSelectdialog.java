package windialog;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import valueObject.Omember;
import wintable.Indexselecttable;

public class CampusSelectdialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private Indexselecttable indexselecttable;
	private CollegeSelectdialog collegeSelecdialog; 
	private String filename;
	public CampusSelectdialog(Omember omember) {
		super();
		JPanel panel = new JPanel();	
		this.indexselecttable = new Indexselecttable("root");
		ListSelectionModel rowsel = indexselecttable.getSelectionModel();
		rowsel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		rowsel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				//값이 변경되지 않는다면?
				if(!e.getValueIsAdjusting()) {	
					int row = indexselecttable.getSelectedRow();
					 filename = (String)indexselecttable.getValueAt(row, 1);
					if(filename != null) {
						int result = JOptionPane.showConfirmDialog(null, filename + "선택하시겠습니까?", null, JOptionPane.YES_NO_OPTION);					
					if(result == JOptionPane.CLOSED_OPTION) {		
					} else if(result == JOptionPane.YES_OPTION) {
						collegeSelecdialog = new CollegeSelectdialog(filename, omember);
					} else {
					}
					}
						}
					}
				});	
		panel.add(indexselecttable);
		panel.setBackground(Color.orange);
		setSize(700,500);
		setLocation(400, 300);
		setVisible(true);
		this.add(panel);
	}

}
