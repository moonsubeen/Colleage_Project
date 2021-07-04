package college_management.my.gui.component.login;

import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.CardPanel;

@SuppressWarnings("serial")
public class LoginCard extends CardPanel{
	public LoginCard(MainGUI frame) {
		super(frame);
		
		setPanel(new LoginTab(frame));
	}
}
