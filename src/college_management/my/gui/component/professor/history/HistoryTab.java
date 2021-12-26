package college_management.my.gui.component.professor.history;

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
import college_management.my.gui.component.admin.lecture.LectureRegDialog;
import college_management.my.gui.component.common.TabPanel;
import college_management.my.gui.component.professor.lecture.LectureListTableAdapter;
import college_management.my.gui.layout.common.LecTableView;
import college_management.my.gui.layout.common.LecView;
import college_management.my.gui.layout.professor.history.ProfessorHistoryLayout;
import college_management.my.service.LectureService;

@SuppressWarnings("serial")
public class HistoryTab extends TabPanel{
	private LecTableView list;
	private LecView info;
	private JTextField searchTxtField;
	
	private ProfessorHistoryLayout layout;
	
	public HistoryTab(MainGUI frame) {
		super(frame);
		
		layout = new ProfessorHistoryLayout();
		add(layout);
	}
	
	public void initLayout() {
		layout.initLayout();
		
		JButton loadBtn = layout.getLoadBtn();
		JButton updateBtn = layout.getUpdateBtn();
		JButton searchBtn = layout.getSearchBtn();
		JLabel label = layout.getLabel();
		
		searchTxtField = layout.getSearchTxtField();
		
		loadBtn.addActionListener(loadListener);
		updateBtn.addActionListener(updateListener);
		searchBtn.addActionListener(searchListener);
		
		list = layout.getList();
		info = layout.getHistoryInfo();	
	}
	
	private void search() {
		if(auth.isLogin()) {
			List<LectureHistory> lectures = lectureService.hread3(searchTxtField.getText());
			list.setModel(new HistotyListTableAdpater(lectures));
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		refresh();
	}

	private void refresh() {
		if (auth.isLogin()) {
			List<LectureHistory> lectures = lectureService.hread2(auth.getUser().getId());
			list.setModel(new HistotyListTableAdpater(lectures));
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
			LectureHistory history = (LectureHistory) info.getData();
			if(lectureService.grade(history.getLecture().getCode(), history.getStudent().getUser().getId(), history.getGrade())) {
				showMessageBox("성적 입력 완료");
				refresh();
			}
		}
	};

	private ActionListener searchListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			showMessageBox("검색 완료");
			search();
		}
	};
}
