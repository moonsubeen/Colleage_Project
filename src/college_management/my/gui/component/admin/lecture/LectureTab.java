package college_management.my.gui.component.admin.lecture;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import college_management.my.db.model.Lecture;
import college_management.my.db.model.Professor;
import college_management.my.db.model.User;
import college_management.my.gui.MainGUI;
import college_management.my.gui.component.admin.user.UserListTableAdapter;
import college_management.my.gui.component.common.TabPanel;
import college_management.my.gui.layout.admin.lecture.AdminBaseLectureDlgView;
import college_management.my.gui.layout.admin.lecture.AdminLectureLayout;
import college_management.my.gui.layout.admin.lecture.AdminLectureRegDlgView;
import college_management.my.gui.layout.common.LecTableView;
import college_management.my.gui.layout.common.LecView;

@SuppressWarnings("serial")
public class LectureTab extends TabPanel{
	private LecTableView list;
	private LecView info;
	private JTextField searchTxtField;
	
	private AdminLectureLayout layout;
	
	public LectureTab(MainGUI frame) {
		super(frame);

		// set layout
		layout = new AdminLectureLayout();
		add(layout);
	}
	
	public void initLayout() {
		layout.initLayout();
		// set button
				
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
			
		// set list
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
			list.setModel(new LectureListTableAdapter(lectures));
		}
	}

	private void refresh() {
		if (auth.isLogin()) {
			List<Lecture> lectures = lectureService.readAll();
			list.setModel(new LectureListTableAdapter(lectures));
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
			Lecture lecture = (Lecture) info.getData();
			if (lectureService.update(lecture.getProfessor().getUser().getId(), lecture.getName(), lecture.getYear(), lecture.getSemester(), lecture.getDay(), lecture.getTime(), lecture.getMax_count(), lecture.getPoint(), lecture.getLecturePlan())) {
				showMessageBox("업데이트 완료");
				refresh();
			}
		}
	};

	private ActionListener registerListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			LectureRegDialog dlg = new LectureRegDialog(frame);
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
