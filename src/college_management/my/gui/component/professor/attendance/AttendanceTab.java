package college_management.my.gui.component.professor.attendance;

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
import college_management.my.gui.layout.professor.attendance.ProfessorAttendanceLayout;

@SuppressWarnings("serial")
public class AttendanceTab extends TabPanel{
	private LecTableView list;
	private LecView info;
	private JTextField searchTxtField;
	
	private ProfessorAttendanceLayout layout;
	
	public AttendanceTab(MainGUI frame) {
		super(frame);
		
		layout = new ProfessorAttendanceLayout();
		add(layout);
	}
	
	public void initLayout() {
		layout.initLayout();
		
		JButton loadBtn = layout.getLoadBtn();
		JButton updateBtn = layout.getUpdateBtn();
		JButton registerBtn = layout.getRegisterBtn();
		JButton searchBtn = layout.getSearchBtn();
		JLabel label = layout.getLabel();
		
		searchTxtField = layout.getSearchTxtField();
		
		loadBtn.addActionListener(loadListener);
		updateBtn.addActionListener(updateListener);
		registerBtn.addActionListener(registerListener);
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
			List<LectureAttendance> attendance = lectureService.aread4(searchTxtField.getText());
			list.setModel(new AttendanceListTableAdpater(attendance));
		}
	}
	
	public void refresh() {
		if(auth.isLogin()) {
			List<LectureAttendance> attendance = lectureService.aread(auth.getUser().getId());
			list.setModel(new AttendanceListTableAdpater(attendance));
		}
	}
	
	private ActionListener loadListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			showMessageBox("목록 새로고침 완료");
			refresh();
		}
	};
	
	private ActionListener updateListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			LectureAttendance attendance = (LectureAttendance) info.getData();
			if(lectureService.update2(attendance.getLecture().getCode(), attendance.getStudent().getUser().getId(), attendance.getAttendance())) {
				showMessageBox("출석 변경 완료");
				refresh();
			}
		}
	};
	
	private ActionListener registerListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			AttendanceRegDialog dlg = new AttendanceRegDialog(frame);
			dlg.show();
		}
	};
	
	private ActionListener searchListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			showMessageBox("검색 완료");
			search();
		}
	};
}
