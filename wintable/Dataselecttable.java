package wintable;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controller.Clecture;
import valueObject.Odata;

public class Dataselecttable extends JTable {
	
	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	private Clecture clecture;
	
	public Dataselecttable(String filename) {
	super();
	this.model = new DefaultTableModel();
	this.setModel(model);
	this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	this.getData(filename);
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
	
}
