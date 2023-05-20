package windialog;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Cchatgi;
import valueObject.Omember;

public class Chatgidialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private Omember omember;
	private JTextField name;
	private JTextField dp;
	private JTextField ad;
	private Cchatgi cchatgi;
	public Chatgidialog() {
		super();
		JPanel jpanel = new JPanel();
		JLabel label3 = new JLabel("이름");
		JLabel label4 = new JLabel("학과");
		JLabel label5 = new JLabel("주소");
		
		this.name = new JTextField(10);
		this.dp = new JTextField(10);
		this.ad = new JTextField(10);
		JButton cgBtn = new JButton("찾기");

		cgBtn.setBackground(Color.white);
		jpanel.setBackground(Color.pink);
		jpanel.add(label3);
		jpanel.add(name);
		jpanel.add(label4);
		jpanel.add(dp);
		jpanel.add(label5);
		jpanel.add(ad);
		jpanel.add(cgBtn);
		add(jpanel);

		setBackground(Color.PINK);
		setSize(800,800);
		setLocation(500, 100);
		setVisible(true);
		
		this.omember = new Omember();
		omember = null;
		this.cchatgi = new Cchatgi();
		cgBtn.addActionListener(new ActionListener() {	
			
			public void actionPerformed(ActionEvent e) {
				Vector<Omember> omembers = cchatgi.readAll("lms");
				for(Omember member : omembers) {
					if(member.getName().equals(name.getText())) {			
						if(member.getDepartment().equals(dp.getText())) {
							if(member.getAddress().equals(ad.getText())) {
								omember = member;
							}
						}
					}
				}
				if(omember != null) {				
					JOptionPane.showMessageDialog(null, "아이디 : " + omember.getId() + 
							"비밀번호 : " + omember.getPassword(), "성공", JOptionPane.PLAIN_MESSAGE);

				} else {
					JOptionPane.showMessageDialog(null, "개인정보가 틀렸습니다.", "실패", JOptionPane.PLAIN_MESSAGE);
				}
				dispose();
			}

		});
	}
			public void initialize() {		
	}
	
}
