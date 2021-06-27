package college_management.my.GUI.component.login;

import javax.swing.JTabbedPane;

import college_management.my.GUI.component.MainGUI;

@SuppressWarnings("serial")
public class LoginTab extends JTabbedPane{
	public LoginTab(MainGUI frame) {
		addTab("로그인", new LoginPanel(frame));
	}

}
