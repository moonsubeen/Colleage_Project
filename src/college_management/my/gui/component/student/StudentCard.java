package college_management.my.gui.component.student;

import java.awt.Color;

import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.CardPanel;

@SuppressWarnings("serial")
public class StudentCard extends CardPanel{
	public StudentCard(MainGUI frame) {
		super(frame);

		setBackground(new Color(153, 204, 255));
		setPanel(new StudentTab(frame));
	}
}
