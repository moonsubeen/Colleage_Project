package college_management.my.gui.component.professor.user;

import java.awt.Graphics;

import college_management.my.db.model.Professor;
import college_management.my.db.model.User;
import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.LecPanel;
import college_management.my.gui.layout.common.LecView;
import college_management.my.gui.layout.professor.ProfessorUserLayout;

public class UserTab extends LecPanel{
	private LecView userInfo;
	private LecView professorInfo;
	
	public UserTab(MainGUI frame) {
		super(frame);
		
		// set layout
		ProfessorUserLayout layout = new ProfessorUserLayout();
		add(layout);
		
		// set info
		userInfo = layout.getUserInfo();
		professorInfo = layout.getProfessorInfo();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		refresh();
	}

	private void refresh() {
		if (auth.isLogin()) {
			Professor professor = professorService.read(auth.getUser().getId());
			professorInfo.setData(professor);

			User user = userService.read(auth.getUser().getId());
			userInfo.setData(user);
		}
	}

}
