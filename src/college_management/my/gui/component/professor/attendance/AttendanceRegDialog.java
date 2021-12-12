package college_management.my.gui.component.professor.attendance;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import college_management.my.db.model.LectureAttendance;
import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.LecPanel;
import college_management.my.gui.layout.professor.attendance.ProfessorAttendanceRegDlgView;

public class AttendanceRegDialog extends LecPanel implements Serializable{
	private ProfessorAttendanceRegDlgView view;
	private ImageIcon icon;
	private String title = "강의 추가 등록하기";
	private Object[] options = new Object[] { "추가", "취소" };
	
	public AttendanceRegDialog(MainGUI frame) {
		super(frame);
		Image img = (new ImageIcon("src/resource/new_user.png")).getImage().getScaledInstance(50, 50,
		Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);
		
		view = new ProfessorAttendanceRegDlgView();
		add(view);
	}
	
	public void show() {
		int selected = JOptionPane.showOptionDialog(null, view, title, JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, icon, options, options[0]);
		if (selected == 0) {
			showMessageBox("등록이 성공했습니다.");
			register();
		} else {
			showMessageBox("취소가 성공했습니다.");
			cancel();
		}
	}
	
	public void cancel() {
		System.out.println("취소 완료");
	}
	
	public void register() {
		LectureAttendance attendance = (LectureAttendance) view.getData();
		lectureService.register3(view.getIdTxtField().getText(), view.getCodeTxtField().getText(), attendance.getMonth(), attendance.getDay(), attendance.getAttendance());
	}
}
