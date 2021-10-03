package college_management.my.gui.component.student.user;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import college_management.my.db.model.Student;
import college_management.my.db.model.User;
import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.LecPanel;
import college_management.my.gui.layout.common.LecView;
import college_management.my.gui.layout.student.user.StudentUserLayout;

@SuppressWarnings("serial")
public class UserTab extends LecPanel{
	private LecView userInfo;
	private LecView studentInfo;

	public UserTab(MainGUI frame) {
		super(frame);

		// set layout
		StudentUserLayout layout = new StudentUserLayout();
		add(layout);

		JButton loadBtn = layout.getLoadBtn();
		JButton updateBtn = layout.getUpdateBtn();
		
		loadBtn.addActionListener(loadListener);
		updateBtn.addActionListener(updateListener);
		
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
	
	private ActionListener loadListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			showMessageBox("목록 새로고침 완료");
			refresh();
		}
	};
	
	private ActionListener updateListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			User user = (User) userInfo.getData();
			if (userService.update(user.getId(), user.getPwd(), user.getName(), user.getEmail(), user.getAddress(), user.getPhoneNumber())) {
				showMessageBox("업데이트 성공");
				refresh();
			}
		}
	};
}
