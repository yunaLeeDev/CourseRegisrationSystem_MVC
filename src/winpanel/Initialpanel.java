package winpanel;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import constant.Cconfig.FVmainFrame;
import valueObject.Omember;
import winFrame.VMainFrame.ActionHandler;
import windialog.Chatgidialog;
import windialog.Hwdrdialog;
import windialog.Logindialog;

public class Initialpanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton loginBtn;
	private JButton hwdrBtn;
	private JButton chatgiBtn;
	private Logindialog logindialog;
	private Omember omember;
	private Hwdrdialog hwdrdialog;
	private Chatgidialog chatgidialog;
	private ActionHandler actionHandler;
	public Initialpanel() {
		super();	
		this.loginBtn = new JButton("LOGIN");
		this.hwdrBtn = new JButton("회원등록"); 
		this.chatgiBtn = new JButton("아이디/비밀번호 찾기");
		loginBtn.setBackground(Color.WHITE);
		hwdrBtn.setBackground(Color.WHITE);
		chatgiBtn.setBackground(Color.WHITE);
		this.add(loginBtn);
		this.add(hwdrBtn);
		this.add(chatgiBtn);
		
		setVisible(true);
		this.setBackground(Color.orange);
		this.setSize(FVmainFrame.size);
		this.setLocation(FVmainFrame.location);	
	}

	public void buttonclick() {
		loginBtn.addActionListener(this.actionHandler);
		loginBtn.setActionCommand("login");
				
		hwdrBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hwdrdialog = new Hwdrdialog();
			}
		});	
		chatgiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chatgidialog = new Chatgidialog();
			}
		});
	}

	public void initialize(ActionHandler actionHandler) {
		this.actionHandler = actionHandler;
		this.buttonclick();
	}
	
}