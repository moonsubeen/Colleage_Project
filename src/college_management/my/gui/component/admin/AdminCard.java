package college_management.my.gui.component.admin;

import java.awt.Color;

import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.CardPanel;
import college_management.my.gui.component.common.CardPanelInterface;

public class AdminCard extends CardPanel{
	private AdminTab adminTab;
	
	public AdminCard(MainGUI frame, CardPanelInterface cardPanelImpl) {
		super(frame, cardPanelImpl);

		setBackground(new Color(204, 204, 255));
		
		adminTab = new AdminTab(frame);
		setPanel(adminTab);
	}
	
	public void init() {
		adminTab.stateChanged(null);
	}
}
