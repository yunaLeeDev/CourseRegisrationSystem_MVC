package windialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.Clecture;
import textview.Vsincheong;
import valueObject.Odata;
import valueObject.Omember;
import wintable.Dataselecttable;

public class ChaekgabangDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private Dataselecttable miridamgitable;
	private Dataselecttable sincheongtable;
	private Vsincheong vsincheong;
	private Clecture cmiridamgi;
	private Odata Selectlecture;
	public ChaekgabangDialog(Omember omember) {
		super();
		LayoutManager layoutManager = new BorderLayout();
		this.setLayout(layoutManager);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JLabel label1 = new JLabel("미리담기 목록");
		JLabel label2 = new JLabel("신청 목록");
		Scanner scanner = new Scanner(System.in);
		
		this.Selectlecture = new Odata();
		
		this.vsincheong = new Vsincheong(scanner);
		this.miridamgitable = new Dataselecttable(omember.getName()+"miridamgi");
		this.sincheongtable = new Dataselecttable(omember.getName());
		this.cmiridamgi = new Clecture();
		
	
		ListSelectionModel rowsel = miridamgitable.getSelectionModel();
		rowsel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		rowsel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(!e.getValueIsAdjusting()) {	
					  int row = miridamgitable.getSelectedRow();
					  Selectlecture.setId((String)miridamgitable.getValueAt(row, 0));
					  Selectlecture.setName((String)miridamgitable.getValueAt(row, 1));
					  Selectlecture.setProfessorname((String)miridamgitable.getValueAt(row, 2));
					  Selectlecture.setCredit((String)miridamgitable.getValueAt(row, 3));
					  Selectlecture.setTime((String)miridamgitable.getValueAt(row, 4));			  
		if(Selectlecture != null) {
			int result = JOptionPane.showConfirmDialog(null, Selectlecture.getName() + "신청하시겠습니까?", null, JOptionPane.YES_NO_OPTION);					
				if(result == JOptionPane.CLOSED_OPTION) {		
					 } else if(result == JOptionPane.YES_OPTION) {
							String siganhawkin = vsincheong.damgi(Selectlecture, omember.getName());
							if(siganhawkin != null) {
					        JOptionPane.showMessageDialog(null,siganhawkin +" 신청되었습니다.");
							} else if(siganhawkin == null) {
								 JOptionPane.showMessageDialog(null,"기존 신청 강좌와 시간이 겹처 신청이 불가능합니다.");
							}
						}	
					} 
						else {
								}
							}
						}
				});		
		String hakjum = cmiridamgi.hakjumhwakin(omember.getName()+"miridamgi");
		JLabel label3 = new JLabel("총 학점 : "+hakjum);
		String hakjum2 = cmiridamgi.hakjumhwakin(omember.getName());
		JLabel label4 = new JLabel("총 학점 : "+hakjum2);
				

		panel1.setSize(200, 100);
		panel2.setSize(200, 100);
		panel1.add(label1, BorderLayout.NORTH);
		panel1.add(miridamgitable, BorderLayout.CENTER);
		panel1.add(label3, BorderLayout.SOUTH);
		panel2.add(label2, BorderLayout.NORTH);
		panel2.add(sincheongtable, BorderLayout.CENTER);
		panel2.add(label4, BorderLayout.SOUTH);
		panel1.setBackground(Color.orange);
		panel2.setBackground(Color.orange);
		add(panel1, BorderLayout.WEST);
		add(panel2, BorderLayout.EAST);
		setSize(1200,600);
		setLocation(200, 100);
		setVisible(true);
	}


}
