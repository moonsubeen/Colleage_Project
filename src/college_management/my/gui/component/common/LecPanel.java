package college_management.my.gui.component.common;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import college_management.my.auth.UserAuth;
import college_management.my.gui.MainGUI;
import college_management.my.service.LectureService;
import college_management.my.service.ProfessorService;
import college_management.my.service.StudentService;
import college_management.my.service.UserService;

@SuppressWarnings("serial")
public class LecPanel extends JPanel {
	protected MainGUI frame;
	protected static UserService userService = UserService.getInstance();
//	protected static SubjectService subjectService = SubjectService.getInstance();
	protected static StudentService studentService = StudentService.getInstance();
	protected static LectureService lectureService = LectureService.getInstance();
	protected static ProfessorService professorService = ProfessorService.getInstance();
	protected static UserAuth auth = UserAuth.getInstance();

	// component
	private JOptionPane op = new JOptionPane();

	public LecPanel(MainGUI frame) {
		this.frame = frame;
	}

	@SuppressWarnings("static-access")
	protected void showMessageBox(String message) {
		op.showMessageDialog(this, message);
	}
}