package newwin;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import controller.Clecture;
import valueObject.Odata;

public class Dataselecttable extends JTable {
	
	private static final long serialVersionUID = 1L;
	private String filename;
	private DefaultTableModel model;
	private Odata odata;
	private Clecture clecture;
	private Odata Selectlecture; 
	
	public Dataselecttable(String filename) {
	super();
	this.model = new DefaultTableModel();
	this.setModel(model);
	this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	this.getData(filename);
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//고쳐야하는것 => 선택된 것의 모든 것을 반환하는 것.
				int row = getSelectedRow();
					  Selectlecture.setId((String)getModel().getValueAt(row, 0));
					  Selectlecture.setName((String)getModel().getValueAt(row, 1));
					  Selectlecture.setProfessorname((String)getModel().getValueAt(row, 2));
					  Selectlecture.setCredit((String)getModel().getValueAt(row, 3));
					  Selectlecture.setTime((String)getModel().getValueAt(row, 4));
				 }
			});
		}

	
	public void getData(String filename2) {
		this.clecture = new Clecture();
		Vector<Odata> olectures = this.clecture.readAll(filename2);
		
		this.model.addColumn("아이디");
		this.model.addColumn("강좌명");
		this.model.addColumn("교수명");
		this.model.addColumn("학점");
		this.model.addColumn("시간");
		
		String row[] = new String[5];
		for(int rowindex = 0; rowindex < olectures.size(); rowindex++) {
			row[0] = olectures.get(rowindex).getId();
			row[1] = olectures.get(rowindex).getName();
			row[2] = olectures.get(rowindex).getProfessorname();
			row[3] = olectures.get(rowindex).getCredit();
			row[4] = olectures.get(rowindex).getTime();
			this.model.addRow(row);
		}
	}
	public Odata getSelectlecture(){
		return this.Selectlecture;
	}

}
