package wintable;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controller.Cindex;
import valueObject.Oindex;

public class Indexselecttable extends JTable{
	
	private static final long serialVersionUID = 1L;
	public DefaultTableModel model;
	private Cindex cindex;
	
	public Indexselecttable(String filename) {
	super();
	this.model = new DefaultTableModel();
	this.setModel(model);
	this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	this.getData(filename);
	}

	public void getData(String filename2) {
		this.cindex = new Cindex();
		Vector<Oindex> oindicies = this.cindex.readAll(filename2);
		
		this.model.addColumn("아이디");
		this.model.addColumn("파일이름");
		
		String row[] = new String[2];
		for(int rowindex = 0; rowindex < oindicies.size(); rowindex++) {
			row[0] = oindicies.get(rowindex).getId();
			row[1] = oindicies.get(rowindex).getChildFileName();
			this.model.addRow(row);
		}
	}
}
