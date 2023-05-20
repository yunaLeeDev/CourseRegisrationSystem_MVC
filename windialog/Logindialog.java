package windialog;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.Clogin;
import valueObject.Ologin;
import valueObject.Omember;
import winFrame.VMainFrame.ActionHandler;

public class Logindialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private Omember omember;
	private Clogin clogin;
	private Ologin ologin;
	private JTextField id;
	private JPasswordField pw;
	public Logindialog(ActionHandler actionHandler) {
		super();
		JPanel jpanel = new JPanel();
		JLabel label1 = new JLabel("아이디 : ");
		JLabel label2 = new JLabel("비밀번호 : ");
		this.id = new JTextField(10);
		this.pw = new JPasswordField(10);
		JButton login = new JButton("로그인");
		login.setBackground(Color.white);
		jpanel.add(label1);
		jpanel.add(id);
		jpanel.add(label2);
		jpanel.add(pw);
		jpanel.add(login);
		jpanel.setBackground(Color.pink);
		add(jpanel);

		setSize(400,500);
		setLocation(500, 100);
		setVisible(true);
		
		login.addActionListener(actionHandler);
		login.setActionCommand("ok");
	}
		
		public Omember getomember() {
					return omember;
							}
		
	public void login() {
		this.clogin = new Clogin();
		this.ologin = new Ologin();
		this.omember = new Omember();
		this.ologin.setId(id.getText());
		this.ologin.setPassword(pw.getText());
		omember = this.clogin.validate(this.ologin);
		setVisible(false);
		if(omember != null) {
			JOptionPane.showMessageDialog(null, "로그인 성공!", "성공여부", JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "로그인 실패!", "성공여부", JOptionPane.PLAIN_MESSAGE);
		}
	}
	public void initialize() {		
}

}
