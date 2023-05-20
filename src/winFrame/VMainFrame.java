package winFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import constant.Cconfig.FVmainFrame;
import valueObject.Omember;
import windialog.Logindialog;
import winpanel.Initialpanel;
import winpanel.Mainpanel;

public class VMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private Initialpanel initialpanel;
	private Mainpanel mainpanel;
	private Logindialog logindialog;
	private Omember omember;
	private ActionHandler actionHandler;
	public VMainFrame()  {
		super();
		this.setSize(FVmainFrame.size);
		this.setLocation(FVmainFrame.location);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.actionHandler = new ActionHandler();	
		    this.initialpanel = new Initialpanel();
		    getContentPane().add(initialpanel);

		}
		
	public void initialize() {
		this.initialpanel.initialize(this.actionHandler);	
	}
	
	public class ActionHandler implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("login")) {
				logindialog = new Logindialog(actionHandler);
			} else if(e.getActionCommand().equals("ok")) {
				logindialog.login();
				omember = logindialog.getomember();
				if(omember != null) {
					//로그인 해서 vmainpanel로 이동
					getContentPane().remove(initialpanel);
					mainpanel = new Mainpanel(omember);
					getContentPane().add(mainpanel);
					}
				} 
			} 
		}
	
	public static void main(String[] args) {
		VMainFrame vMainFrame = new VMainFrame();
		vMainFrame.initialize();
		vMainFrame.setVisible(true);		
	}

}
