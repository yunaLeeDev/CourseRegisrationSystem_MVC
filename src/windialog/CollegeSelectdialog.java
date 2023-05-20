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

public class CollegeSelectdialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private Indexselecttable indexselecttable;
	private DepartmentSelectdialog departmentSelectdialog; 
	private String filename1;
	public CollegeSelectdialog(String filename, Omember omember) {
		super();
		JPanel panel = new JPanel();	
		//테이블 추가 + 테이블 선택해서 자식 이름 반환받음.
		indexselecttable = new Indexselecttable(filename);
		ListSelectionModel rowsel = indexselecttable.getSelectionModel();
		rowsel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		rowsel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(!e.getValueIsAdjusting()) {		
					int row = indexselecttable.getSelectedRow();
					 filename1 = (String) indexselecttable.getValueAt(row, 1);
					//담기는 것까지 확인함
					if(filename1 != null) {
						int result = JOptionPane.showConfirmDialog(null, filename1 + "선택하시겠습니까?", null, JOptionPane.YES_NO_OPTION);
						
					if(result == JOptionPane.CLOSED_OPTION) {		
					} else if(result == JOptionPane.YES_OPTION) {
						departmentSelectdialog = new DepartmentSelectdialog(filename1, omember);
					} else {
					}
					}
						}
					}
				});		
		panel.add(indexselecttable);

		panel.setBackground(Color.orange);
		setSize(600,300);
		setLocation(400, 300);
		setVisible(true);
		this.add(panel);
	  }
	}

