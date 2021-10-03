package college_management.my.gui.component.student.attendance;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import college_management.my.db.model.LectureAttendance;
import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.TabPanel;
import college_management.my.gui.layout.common.LecTableView;
import college_management.my.gui.layout.common.LecView;
import college_management.my.gui.layout.student.attendance.StudentAttendanceLayout;

@SuppressWarnings("serial")
public class AttendanceTab extends TabPanel{
	private LecTableView list;
	private LecView info;
	private JTextField searchTxtField;
	
	public AttendanceTab(MainGUI frame) {
		super(frame);
		
		StudentAttendanceLayout layout = new StudentAttendanceLayout();
		add(layout);
		
		JButton loadBtn = layout.getLoadBtn();
		JButton searchBtn = layout.getSearchBtn();
		JLabel label = layout.getLabel();
		
		searchTxtField = layout.getSearchTxtField();
		
		loadBtn.addActionListener(loadListener);
		searchBtn.addActionListener(searchListener);
		
		list = layout.getList();
		info = layout.getAttendanceInfo();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		refresh();
	}
	
	public void search() {
		if(auth.isLogin()) {
			List<LectureAttendance> attendance = lectureService.aread3(searchTxtField.getText(), auth.getUser().getId());
			list.setModel(new AttendanceListTableAdpater(attendance));
		}
	}
	
	public void refresh() {
		if(auth.isLogin()) {
			List<LectureAttendance> attendance = lectureService.readAll2(auth.getUser().getId());
			list.setModel(new AttendanceListTableAdpater(attendance));
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
