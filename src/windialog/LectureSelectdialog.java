package windialog;

import java.awt.Color;
import java.io.File;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import textview.Vmiridamgi;
import textview.Vsincheong;
import valueObject.Odata;
import valueObject.Omember;
import wintable.Dataselecttable;

public class LectureSelectdialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private Dataselecttable dataselecttable;
	private Vsincheong vsincheong;
	private Vmiridamgi vmiridamgi;
	private Odata Selectlecture; 
	
	public LectureSelectdialog(String filename, Omember omember) {
		super();
		Scanner scanner = new Scanner(System.in);
		JPanel panel = new JPanel();	
		this.Selectlecture = new Odata();
		//테이블 추가 + 테이블 선택해서 자식 이름 반환받음.
		this.dataselecttable = new Dataselecttable(filename);
		//정상작동
		ListSelectionModel rowsel = dataselecttable.getSelectionModel();
		rowsel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		rowsel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// 값이 변경되지 않는다면?
				if(!e.getValueIsAdjusting()) {	
					  int row = dataselecttable.getSelectedRow();
					  Selectlecture.setId((String)dataselecttable.getValueAt(row, 0));
					  Selectlecture.setName((String)dataselecttable.getValueAt(row, 1));
					  Selectlecture.setProfessorname((String)dataselecttable.getValueAt(row, 2));
					  Selectlecture.setCredit((String)dataselecttable.getValueAt(row, 3));
					  Selectlecture.setTime((String)dataselecttable.getValueAt(row, 4));
					  if(Selectlecture != null) {
						int result = JOptionPane.showConfirmDialog(null, Selectlecture.getName() + "선택하시겠습니까?", null, JOptionPane.YES_NO_OPTION);					
					if(result == JOptionPane.CLOSED_OPTION) {		
					} else if(result == JOptionPane.YES_OPTION) {
						Object[] option={"미리담기","신청하기"};
					    int response=JOptionPane.showOptionDialog(null, "원하는 기능을 선택하세요.","선택지",
					    		JOptionPane.DEFAULT_OPTION ,JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
					    if(response==0){
							vmiridamgi = new Vmiridamgi(scanner);
							vmiridamgi.damgi(Selectlecture, omember.getName());
					        JOptionPane.showMessageDialog(null,Selectlecture.getName()+" 책가방에 담았습니다.");
					    }else if(response==1){
					    	vsincheong = new Vsincheong(scanner);
					    	String siganhawkin = vsincheong.damgi(Selectlecture, omember.getName());
							if(siganhawkin != null) {
					        JOptionPane.showMessageDialog(null,siganhawkin +" 신청되었습니다.");
							} else if(siganhawkin == null) {
								 JOptionPane.showMessageDialog(null,"기존 신청 강좌와 시간이 겹처 신청이 불가능합니다.");
							}
					    }	
					} else {
					}
					}
						}
					}
				});					
	
		panel.add(dataselecttable);
		panel.setBackground(Color.orange);
		setSize(500,200);
		setLocation(400, 300);
		setVisible(true);
		this.add(panel);
	
	}


}
