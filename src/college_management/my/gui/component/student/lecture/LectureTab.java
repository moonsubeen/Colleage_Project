package college_management.my.gui.component.student.lecture;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import college_management.my.db.model.Lecture;
import college_management.my.db.model.LectureAttendance;
import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.TabPanel;
import college_management.my.gui.layout.common.LecTableView;
import college_management.my.gui.layout.common.LecView;
import college_management.my.gui.layout.student.lecture.StudentLectureLayout;

@SuppressWarnings("serial")
public class LectureTab extends TabPanel{
	private LecTableView list;
	private LecView info;
	private JTextField searchTxtField;
	
	private StudentLectureLayout layout;
	
	public LectureTab(MainGUI frame) {
		super(frame);
		
		layout = new StudentLectureLayout();
		add(layout);
	}
	
	public void initLayout() {
		layout.initLayout();
		
		// set button
		JButton loadBtn = layout.getLoadBtn();
		JButton searchBtn = layout.getSearchBtn();
		JButton applictionaBtn = layout.getApplicationBtn();
		
		JLabel label = layout.getLabel();
		
		searchTxtField = layout.getSearchTxtField();
		
		loadBtn.addActionListener(loadListener);
		applictionaBtn.addActionListener(applicationListener);
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
			List<Lecture> lectures = new ArrayList<Lecture>();
			lectures.add(lectureService.read(searchTxtField.getText()));
			list.setModel(new LectureListTableAdpater(lectures));
		}
	}
	
	private void refresh() {
		if (auth.isLogin()) {
			List<Lecture> lectures = lectureService.readAll();
			list.setModel(new LectureListTableAdpater(lectures));
		}
	}
	
	private ActionListener loadListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			showMessageBox("목록 새로고침 완료");
			refresh();
		}
	};
	
	private ActionListener applicationListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Lecture lecture = (Lecture) info.getData();
			lectureService.register(lecture.getCode(), auth.getUser().getId());
			showMessageBox("수강신청 완료");
		}
	};
	
	private ActionListener searchListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			showMessageBox("검색 완료");
			search();
		}
	};
}
