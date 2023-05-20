package winpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import valueObject.Omember;
import windialog.CampusSelectdialog;
import windialog.ChaekgabangDialog;
import windialog.Doummaldialog;

public class Mainpanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private CampusSelectdialog campusSelectdialog;
	private ChaekgabangDialog chaekgabangDialog;
	private Doummaldialog doummaldialog;
	public Mainpanel(Omember omember) {
		super();

		JButton doummal = new JButton("도움말");		
		JButton gabang = new JButton("책가방 가기");
		JButton sgsc = new JButton("강좌선택 하기");
		this.setBackground(Color.PINK);
		sgsc.setBackground(Color.WHITE);
		gabang.setBackground(Color.WHITE);
		doummal.setBackground(Color.white);
		this.add(sgsc);
		this.add(gabang);
		this.add(doummal);
		
		
		doummal.addActionListener( new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				doummaldialog = new Doummaldialog(omember);
			}
		});	
		gabang.addActionListener( new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				chaekgabangDialog = new ChaekgabangDialog(omember);
			}
		});	
		sgsc.addActionListener( new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//캠퍼스 선택 다이얼로그 뜰거야
				campusSelectdialog = new CampusSelectdialog(omember);
			}
		});	
	}

}
