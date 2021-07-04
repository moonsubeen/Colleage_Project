package college_management.my.gui.component.admin;

import java.awt.Color;

import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.CardPanel;

public class AdminCard extends CardPanel{
	public AdminCard(MainGUI frame) {
		super(frame);

		setBackground(new Color(204, 204, 255));
		setPanel(new AdminTab(frame));
	}
}
