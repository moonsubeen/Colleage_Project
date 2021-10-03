package college_management.my.gui.component.professor.lecture;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import college_management.my.db.model.Lecture;
import college_management.my.gui.MainGUI;
import college_management.my.gui.component.professor.lecture.LectureListTableAdapter;
import college_management.my.gui.component.professor.lecture.LectureRegDialog;
import college_management.my.gui.component.common.TabPanel;
import college_management.my.gui.layout.common.LecTableView;
import college_management.my.gui.layout.common.LecView;
import college_management.my.gui.layout.professor.lecture.ProfessorLectureLayout;

@SuppressWarnings("serial")
public class LectureTab extends TabPanel{
	private LecTableView list;
	private LecView info;
	private JTextField searchTxtField;

	public LectureTab(MainGUI frame) {
		super(frame);

		// set layout
		ProfessorLectureLayout layout = new ProfessorLectureLayout();
		add(layout);

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

	private void refresh() {
		if (auth.isLogin()) {
			List<Lecture> lectures = lectureService.readAll(auth.getUser().getId());
			list.setModel(new LectureListTableAdapter(lectures));
		}
	}
	
	public void search() {
		if(auth.isLogin()) {
			List<Lecture> lectures = new ArrayList<Lecture>();
			lectures.add(lectureService.read(searchTxtField.getText()));
			list.setModel(new LectureListTableAdapter(lectures));
		}
	}

	private ActionListener loadListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			showMessageBox("새로고침 완료");
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
