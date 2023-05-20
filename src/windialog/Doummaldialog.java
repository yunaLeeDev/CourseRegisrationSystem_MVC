package windialog;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import valueObject.Omember;

public class Doummaldialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public Doummaldialog(Omember omember) {
		super();
		JPanel panel = new JPanel();
		JButton sgsc = new JButton("강좌선택 방법");		
		JButton gabang = new JButton("책가방 안내");
		panel.setBackground(Color.orange);
		sgsc.setBackground(Color.WHITE);
		gabang.setBackground(Color.WHITE);
		panel.add(sgsc);
		panel.add(gabang);
		
		gabang.addActionListener( new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				 JOptionPane.showMessageDialog(null, "책가방 버튼 클릭 > 미리담기에서 신청할 강좌 선택 > 신청"
				 		+ " *단, 시간이 겹치는 강좌는 신청되지 않음*", "책가방 이용 안내", JOptionPane.INFORMATION_MESSAGE);

			}			
		});	
		sgsc.addActionListener( new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				 JOptionPane.showMessageDialog(null, "수강신청 버튼 클릭 > 캠퍼스 선택 > 소속대학 선택 > 소속학과 선택 > 강좌 선택 > 미리담기 / 바로 신청 결정"
				 		, "수강신청 이용 안내", JOptionPane.INFORMATION_MESSAGE);
			}
		});	
		
		
		this.add(panel);
		setSize(400,400);
		setLocation(500, 100);
		setVisible(true);
	}

}
