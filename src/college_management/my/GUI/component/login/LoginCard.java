package college_management.my.GUI.component.login;

import college_management.my.GUI.component.MainGUI;
import college_management.my.GUI.component.common.CardPanel;

@SuppressWarnings("serial")
public class LoginCard extends CardPanel{
	public LoginCard(MainGUI frame) {
		super(frame);
		
		setPanel(new LoginTab(frame));
	}
}
