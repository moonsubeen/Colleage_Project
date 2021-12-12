package college_management.my.gui.component.student;

import javax.swing.JTabbedPane;

import college_management.my.gui.MainGUI;
import college_management.my.gui.component.student.attendance.AttendanceTab;
import college_management.my.gui.component.student.history.HistoryTab;
import college_management.my.gui.component.student.info.InfoTab;
import college_management.my.gui.component.student.lecture.LectureTab;
import college_management.my.gui.component.student.schedule.ScheduleTab;
import college_management.my.gui.component.student.user.UserTab;

@SuppressWarnings("serial")
public class StudentTab extends JTabbedPane{
	public StudentTab(MainGUI frame) {
		addTab("내 정보", new UserTab(frame));
		addTab("내 기타정보", new InfoTab(frame));
		addTab("수강 강의 목록", new LectureTab(frame));
		addTab("내 강의 목록", new ScheduleTab(frame));
		addTab("내 강의 성적 보기", new HistoryTab(frame));
		addTab("내 강의 출석 보기", new AttendanceTab(frame));
	}
}
