package college_management.my.gui.component.student.schedule;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import college_management.my.db.model.Lecture;
import college_management.my.db.model.LectureHistory;
import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.TabPanel;
import college_management.my.gui.layout.common.LecTableView;
import college_management.my.gui.layout.common.LecView;
import college_management.my.gui.layout.student.schedule.StudentScheduleLayout;

@SuppressWarnings("serial")
public class ScheduleTab extends TabPanel{
	private LecTableView list;
	private LecView info;
	private JTextField searchTxtField;
	
	public ScheduleTab(MainGUI frame) {
		super(frame);
		
		StudentScheduleLayout layout = new StudentScheduleLayout();
		add(layout);
		
		// set button
		JButton loadBtn = layout.getLoadBtn();
		JButton searchBtn = layout.getSearchBtn();
		JLabel label = layout.getLabel();
		
		searchTxtField = layout.getSearchTxtField();
				
		loadBtn.addActionListener(loadListener);
		searchBtn.addActionListener(searchListener);
		
		list = layout.getList();
		info = layout.getLectureInfo();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		refresh();
	}
	
	private void search() {
		if(auth.isLogin()) {
			List<LectureHistory> lectures = new ArrayList<LectureHistory>();
			lectures.add(lectureService.hread3(searchTxtField.getText(), auth.getUser().getId()));
			list.setModel(new ScheduleListTableAdpater(lectures));
		}
	}
	
	private void refresh() {
		if (auth.isLogin()) {
			List<LectureHistory> lectures = lectureService.hread(auth.getUser().getId());
			list.setModel(new ScheduleListTableAdpater(lectures));
		}
	}
	
	private ActionListener loadListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			showMessageBox("목록 새로고침 완료");
			refresh();
		}
	};
	
	private ActionListener searchListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			showMessageBox("검색 완료");
			search();
		}
	};
}
