package college_management.my.gui.component.professor;

import java.awt.Frame;

import javax.swing.JTabbedPane;

import college_management.my.gui.MainGUI;
import college_management.my.gui.component.professor.lecture.LectureTab;
import college_management.my.gui.component.professor.user.UserTab;

@SuppressWarnings("serial")
public class ProfessorTab extends JTabbedPane{
	public ProfessorTab(MainGUI frame) {
		addTab("내 정보", new UserTab(frame));
		addTab("내 강의정보", new LectureTab(frame));
	}
}
