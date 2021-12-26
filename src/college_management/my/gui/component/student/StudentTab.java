package college_management.my.gui.component.student;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import college_management.my.gui.MainGUI;
import college_management.my.gui.component.student.attendance.AttendanceTab;
import college_management.my.gui.component.student.history.HistoryTab;
import college_management.my.gui.component.student.info.InfoTab;
import college_management.my.gui.component.student.lecture.LectureTab;
import college_management.my.gui.component.student.schedule.ScheduleTab;
import college_management.my.gui.component.student.user.UserTab;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

@SuppressWarnings("serial")
public class StudentTab extends JTabbedPane implements ChangeListener  {
	private UserTab userTab;
	private InfoTab infoTab;
	private LectureTab lectureTab;
	private ScheduleTab scheduleTab;
	private HistoryTab historyTab;
	private AttendanceTab attendanceTab;
	
	public StudentTab(MainGUI frame) {
		userTab = new UserTab(frame);
		infoTab = new InfoTab(frame);
		lectureTab = new LectureTab(frame);
		scheduleTab = new ScheduleTab(frame);
		historyTab = new HistoryTab(frame);
		attendanceTab = new AttendanceTab(frame);
		
		addTab("내 정보", userTab);
		addTab("내 기타정보", infoTab);
		addTab("수강 강의 목록", lectureTab);
		addTab("내 강의 목록", scheduleTab);
		addTab("내 강의 성적 보기", historyTab);
		addTab("내 강의 출석 보기", attendanceTab);
		
		addChangeListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		userTab.initLayout();
		infoTab.initLayout();
		lectureTab.initLayout();
		scheduleTab.initLayout();
		historyTab.initLayout();
		attendanceTab.initLayout();
	}
}
