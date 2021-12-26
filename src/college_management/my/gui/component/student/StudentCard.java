package college_management.my.gui.component.student;

import java.awt.Color;

import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.CardPanel;
import college_management.my.gui.component.common.CardPanelInterface;


@SuppressWarnings("serial")
public class StudentCard extends CardPanel{
	private StudentTab studentTab;
	
	public StudentCard(MainGUI frame, CardPanelInterface cardPanelImpl) {
		super(frame, cardPanelImpl);

		setBackground(new Color(153, 204, 255));
		studentTab = new StudentTab(frame);
		
		setPanel(studentTab);
	}
	
	public void init() {
		studentTab.stateChanged(null);
	}
}
