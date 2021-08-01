package college_management.my.gui.layout.professor;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

import college_management.my.gui.layout.common.LecView;

@SuppressWarnings("serial")
public class ProfessorUserLayout extends JPanel{
	private LayoutManager layout;

	private LecView userInfo;
	private LecView professorInfo;
	
	public ProfessorUserLayout(){
		userInfo = new ProfessorUserInfoView();
		userInfo.setPreferredSize(new Dimension(400, 400));
		
		professorInfo = new ProfessorInfoView();
		professorInfo.setPreferredSize(new Dimension(400, 400));

		initLayout();
	}
	
	private void initLayout() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 0;
		add(userInfo, c);

		c.gridx = 1;
		c.gridy = 0;
		add(professorInfo, c);
	}

	public LayoutManager getLayout() {
		return layout;
	}

	public LecView getUserInfo() {
		return userInfo;
	}

	public LecView getProfessorInfo() {
		return professorInfo;
	}

}
