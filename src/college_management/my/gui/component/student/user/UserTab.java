package college_management.my.gui.component.student.user;

import java.awt.Graphics;

import college_management.my.db.model.Student;
import college_management.my.db.model.User;
import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.LecPanel;
import college_management.my.gui.layout.common.LecView;
import college_management.my.gui.layout.student.StudentUserLayout;

@SuppressWarnings("serial")
public class UserTab extends LecPanel{
	private LecView userInfo;
	private LecView studentInfo;

	public UserTab(MainGUI frame) {
		super(frame);

		// set layout
		StudentUserLayout layout = new StudentUserLayout();
		add(layout);

		// set info
		userInfo = layout.getUserInfo();
		studentInfo = layout.getStudentInfo();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		refresh();
	}

	private void refresh() {
		if (auth.isLogin()) {
			Student student = studentService.read(auth.getUser().getId());
			studentInfo.setData(student);

			User user = userService.read(auth.getUser().getId());
			userInfo.setData(user);
		}
	}

}
