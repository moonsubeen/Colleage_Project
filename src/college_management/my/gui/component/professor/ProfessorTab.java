package college_management.my.gui.component.professor;

import java.awt.Frame;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import college_management.my.gui.MainGUI;
import college_management.my.gui.component.professor.attendance.AttendanceTab;
import college_management.my.gui.component.professor.history.HistoryTab;
import college_management.my.gui.component.professor.lecture.LectureTab;
import college_management.my.gui.component.professor.user.UserTab;
import college_management.my.gui.component.student.info.InfoTab;
import college_management.my.gui.component.student.schedule.ScheduleTab;

@SuppressWarnings("serial")
public class ProfessorTab extends JTabbedPane implements ChangeListener{
	private UserTab userTab;
	private LectureTab lectureTab;
	private HistoryTab historyTab;
	private AttendanceTab attendanceTab;
	
	public ProfessorTab(MainGUI frame) {
		userTab = new UserTab(frame);
		lectureTab = new LectureTab(frame);
		historyTab = new HistoryTab(frame);
		attendanceTab = new AttendanceTab(frame);
		
		addTab("내 정보", userTab);
		addTab("내 강의정보", lectureTab);
		addTab("내 강의 수강 인원 점검", historyTab);
		addTab("내 강의 인원 출석 확인", attendanceTab);
		
		addChangeListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		lectureTab.initLayout();
		historyTab.initLayout();
		attendanceTab.initLayout();
	}
}
