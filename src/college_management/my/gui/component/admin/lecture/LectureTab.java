package college_management.my.gui.component.admin.lecture;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import college_management.my.db.model.Lecture;
import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.TabPanel;
import college_management.my.gui.layout.admin.AdminLectureLayout;
import college_management.my.gui.layout.common.LecTableView;
import college_management.my.gui.layout.common.LecView;

@SuppressWarnings("serial")
public class LectureTab extends TabPanel{
	private LecTableView list;
	private LecView info;

	public LectureTab(MainGUI frame) {
		super(frame);

		// set layout
		AdminLectureLayout layout = new AdminLectureLayout();
		add(layout);

		// set button
		JButton loadBtn = layout.getLoadBtn();
		JButton updateBtn = layout.getUpdateBtn();
		JButton registerBtn = layout.getRegisterBtn();
//		JButton deleteBtn = layout.getDeleteBtn();
		loadBtn.addActionListener(loadListener);
		updateBtn.addActionListener(updateListener);
		registerBtn.addActionListener(registerListener);
//		deleteBtn.addActionListener(deleteListener);

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
//			List<Lecture> lectures = lectureService.readAll();
//			list.setModel(new LectureListTableAdapter(lectures));
		}
	}

	private ActionListener loadListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			refresh();
		}
	};

	private ActionListener updateListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Lecture lecture = (Lecture) info.getData();
//			if (lectureService.update(lecture.getCode(), lecture)) {
//				refresh();
//			}
		}
	};

	private ActionListener registerListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Lecture lecture = (Lecture) info.getData();
//			if (lectureService.register(lecture.getCode(), lecture)) {
//				refresh();
//			}
		}
	};

//	private ActionListener deleteListener = new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			Lecture Lecture = (Lecture) info.getData();
//			if (userService.delete(Lecture.getCode())) {
//				refresh();
//			}
//		}
//	};
}
