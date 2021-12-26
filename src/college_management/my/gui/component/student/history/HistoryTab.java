package college_management.my.gui.component.student.history;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import college_management.my.db.model.LectureHistory;
import college_management.my.db.model.Student;
import college_management.my.db.model.User;
import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.TabPanel;
import college_management.my.gui.layout.common.LecTableView;
import college_management.my.gui.layout.common.LecView;
import college_management.my.gui.layout.student.history.StudentHistoryLayout;
import college_management.my.util.ExcelWrapper;

@SuppressWarnings("serial")
public class HistoryTab extends TabPanel{
	private LecTableView list;
	private LecView info;
	private JTextField searchTxtField;
	
	private StudentHistoryLayout layout;
	
	public HistoryTab(MainGUI frame) {
		super(frame);
		
		layout =  new StudentHistoryLayout();
		add(layout);
		
		initLayout();
	}
	
	public void initLayout() {
		layout.initLayout();
		
		JButton loadBtn = layout.getLoadBtn();
		JButton problemBtn = layout.getProblemBtn();
		JButton evaluationBtn = layout.getEvaluationBtn();
		JButton searchBtn = layout.getSearchBtn();
		JButton exportexcelBtn = layout.getExportexcelBtn();
		JLabel label = layout.getLabel();
		
		searchTxtField = layout.getSearchTxtField();
		
		loadBtn.addActionListener(loadListener);
		problemBtn.addActionListener(problemListener);
		evaluationBtn.addActionListener(evaluationListener);
		searchBtn.addActionListener(searchListener);
		exportexcelBtn.addActionListener(exportexcelListener);
		
		list = layout.getList();
		info = layout.getHistoryInfo();	
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		refresh();
	}
	
	private void refresh() {
		if (auth.isLogin()) {
			List<LectureHistory> lectures = lectureService.hread(auth.getUser().getId());
			list.setModel(new HistotyListTableAdpater(lectures));
		}
	}
	
	private void search() {
		if(auth.isLogin()) {
			List<LectureHistory> lectures = new ArrayList<LectureHistory>();
			lectures.add(lectureService.hread3(searchTxtField.getText(), auth.getUser().getId()));
			list.setModel(new HistotyListTableAdpater(lectures));
		}
	}
	
	private ActionListener loadListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			showMessageBox("목록 새로고침 완료");
			refresh();
		}
	};

	private ActionListener problemListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			LectureHistory history = (LectureHistory) info.getData();
			if(lectureService.problem(history.getLecture().getCode(), auth.getUser().getId(), history.getProblem())) {
				showMessageBox("문제 제기 완료");
				refresh();
			}
		}
	};
	
	private ActionListener evaluationListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			LectureHistory history = (LectureHistory) info.getData();
			if(lectureService.evaluation(history.getLecture().getCode(), auth.getUser().getId(), history.getEvaluation())) {
				showMessageBox("강의 평가 완료");
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
	
	private ActionListener exportexcelListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(auth.isLogin()) {
				User user = userService.read(auth.getUser().getId());
				Student student = studentService.read(auth.getUser().getId());
				List<LectureHistory> lectures = lectureService.hread(auth.getUser().getId());
				ExcelWrapper wrapper = new ExcelWrapper();
				
				wrapper.init(user, student, lectures, auth.getUser().getId() + " " + auth.getUser().getName() + " 성적점수");
				showMessageBox("엑셀 파일로 내보내기완료");
			}
		}
	};
	
}	
