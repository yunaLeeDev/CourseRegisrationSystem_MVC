package windialog;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Chwdr;
import valueObject.Omember;

public class Hwdrdialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private Omember omember;
	private Chwdr chwdr;
	public Hwdrdialog() {
		super();
		JPanel jpanel = new JPanel();
		JLabel label1 = new JLabel("아이디");
		JLabel label2 = new JLabel("비밀번호");
		JLabel label3 = new JLabel("이름");
		JLabel label4 = new JLabel("학과");
		JLabel label5 = new JLabel("주소");
		
		JTextField id = new JTextField(10);
		JTextField pw = new JTextField(10);
		JTextField name = new JTextField(10);
		JTextField dp = new JTextField(10);
		JTextField ad = new JTextField(10);
		
		JButton drBtn = new JButton("등록");

		drBtn.setBackground(Color.white);
		jpanel.setBackground(Color.pink);
		jpanel.add(label1);
		jpanel.add(id);
		jpanel.add(label2);
		jpanel.add(pw);
		jpanel.add(label3);
		jpanel.add(name);
		jpanel.add(label4);
		jpanel.add(dp);
		jpanel.add(label5);
		jpanel.add(ad);	
		jpanel.add(drBtn);
		
		this.add(jpanel);
		setSize(800,800);
		setLocation(500, 100);
		setVisible(true);
		this.chwdr = new Chwdr();
		this.omember = new Omember();
		drBtn.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				omember.setId(id.getText());
				omember.setPassword(pw.getText());
				omember.setName(name.getText());
				omember.setDepartment(dp.getText());
				omember.setAddress(ad.getText());
				chwdr.setmember(omember);	
					JOptionPane.showMessageDialog(null, "등록 성공!", "성공여부", JOptionPane.PLAIN_MESSAGE);
				dispose();
			}
		});
	}
		public void initialize() {		
			}
			
}
