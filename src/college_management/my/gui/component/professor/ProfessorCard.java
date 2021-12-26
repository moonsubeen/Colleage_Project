package college_management.my.gui.component.professor;

import java.awt.Color;

import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.CardPanel;
import college_management.my.gui.component.common.CardPanelInterface;

@SuppressWarnings("serial")
public class ProfessorCard extends CardPanel{
	private ProfessorTab professorTab;
	
	public ProfessorCard(MainGUI frame, CardPanelInterface cardPanelImpl) {
		super(frame, cardPanelImpl);

		setBackground(new Color(153, 200, 255));
		
		professorTab = new ProfessorTab(frame);
		setPanel(professorTab);
	}
	
	public void init() {
		professorTab.stateChanged(null);
	}
}

