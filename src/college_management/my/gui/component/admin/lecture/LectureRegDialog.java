package college_management.my.gui.component.admin.lecture;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import college_management.my.db.model.Lecture;
import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.LecPanel;
import college_management.my.gui.layout.admin.AdminLectureRegDlgView;
import college_management.my.gui.layout.admin.AdminUserInfoRegDlgView;

public class LectureRegDialog extends LecPanel implements Serializable{
	private AdminLectureRegDlgView view;
	private ImageIcon icon;
	private String title = "강의 추가 등록하기";
	private Object[] options = new Object[] { "취소", "추가" };
	
	public LectureRegDialog(MainGUI frame) {
		super(frame);

		// set dialog image
		Image img = (new ImageIcon("src/resource/new_user.png")).getImage().getScaledInstance(50, 50,
				Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);

		// set view
		view = new AdminLectureRegDlgView();
		add(view);
	}
	
	public void show() {
		int selected = JOptionPane.showOptionDialog(null, view, title, JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, icon, options, options[0]);
		if (selected == 0) {
			showMessageBox("취소가 성공했습니다.");
			cancel();
		} else {
			showMessageBox("등록이 성공했습니다.");
			register();
		}
	}
	
	public void cancel() {
		System.out.println("취소 완료");
	}
	
	public void register() {
		Lecture lecture = (Lecture) view.getData();
		lectureService.register(view.getIdTxtField().getText(), lecture.getCode(), lecture.getName(), lecture.getYear(), lecture.getSemester(), lecture.getDay(), lecture.getTime(), lecture.getMax_count(), lecture.getPoint(), lecture.getLecturePlan());
	}
}
