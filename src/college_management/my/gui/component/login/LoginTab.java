package college_management.my.gui.component.login;

import javax.swing.JTabbedPane;

import college_management.my.gui.MainGUI;

@SuppressWarnings("serial")
public class LoginTab extends JTabbedPane{
	public LoginTab(MainGUI frame) {
		addTab("로그인", new LoginPanel(frame));
	}

}
