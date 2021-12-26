package college_management.my.gui.component.login;

import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.CardPanel;
import college_management.my.gui.component.common.CardPanelInterface;

@SuppressWarnings("serial")
public class LoginCard extends CardPanel{
	public LoginCard(MainGUI frame, CardPanelInterface cardPanelImpl) {
		super(frame, cardPanelImpl);
		
		setPanel(new LoginTab(frame));
	}
}
