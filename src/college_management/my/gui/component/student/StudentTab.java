package college_management.my.gui.component.student;

import javax.swing.JTabbedPane;

import college_management.my.gui.MainGUI;
import college_management.my.gui.component.student.user.UserTab;

@SuppressWarnings("serial")
public class StudentTab extends JTabbedPane{
	public StudentTab(MainGUI frame) {
		addTab("내 정보", new UserTab(frame));
//		addTab("내 시간표", new ScheduleTab(frame));
//		addTab("내 성적", new GradeTab(frame));
	}
}
