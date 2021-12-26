package college_management.my.gui.component.admin;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import college_management.my.gui.MainGUI;
import college_management.my.gui.component.admin.lecture.LectureTab;
import college_management.my.gui.component.admin.user.UserTab;
import college_management.my.gui.component.common.Tab;

public class AdminTab extends JTabbedPane implements ChangeListener{
	private List<Tab> activities;
	private UserTab userTab;
	private LectureTab lectureTab;
	
	public AdminTab(MainGUI frame) {
		activities = new ArrayList<Tab>();
		userTab = new UserTab(frame);
		lectureTab = new LectureTab(frame);
		
		activities.add(new Tab("회원 정보", userTab));
		activities.add(new Tab("강의 정보", lectureTab));
		
		for (int i = 0; i < activities.size(); i++) {
			Tab activity = activities.get(i);
			addTab(activity.getName(), activity.getPanel());
		}
		
		addChangeListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// 탭 변경시 반영을 위함 (현재 미사용 코드)
		activities.get(this.getSelectedIndex()).getPanel().onResumeData();
		
		userTab.initLayout();
		lectureTab.initLayout();
	}
}
