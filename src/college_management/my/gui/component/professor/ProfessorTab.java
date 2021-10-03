package college_management.my.gui.component.professor;

import java.awt.Frame;

import javax.swing.JTabbedPane;

import college_management.my.gui.MainGUI;
import college_management.my.gui.component.professor.attendance.AttendanceTab;
import college_management.my.gui.component.professor.history.HistoryTab;
import college_management.my.gui.component.professor.lecture.LectureTab;
import college_management.my.gui.component.professor.user.UserTab;

@SuppressWarnings("serial")
public class ProfessorTab extends JTabbedPane{
	public ProfessorTab(MainGUI frame) {
		addTab("내 정보", new UserTab(frame));
		addTab("내 강의정보", new LectureTab(frame));
		addTab("내 강의 수강 인원 점검", new HistoryTab(frame));
		addTab("내 강의 인원 출석 확인", new AttendanceTab(frame));
	}
}
