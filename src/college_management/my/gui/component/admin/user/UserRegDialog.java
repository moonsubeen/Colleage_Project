package college_management.my.gui.component.admin.user;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import college_management.my.api.config.Permission;
import college_management.my.db.model.Professor;
import college_management.my.db.model.Student;
import college_management.my.db.model.User;
import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.LecPanel;
import college_management.my.gui.layout.admin.AdminUserInfoRegDlgView;

public class UserRegDialog extends LecPanel implements Serializable{
	private AdminUserInfoRegDlgView view;
	private ImageIcon icon;
	private String title = "사용자 추가 등록하기";
	private Object[] options = new Object[] { "취소", "추가" };

	private JComboBox<Permission> roleComboBox;

	public UserRegDialog(MainGUI frame) {
		super(frame);

		// set dialog image
		Image img = (new ImageIcon("src/resource/new_user.png")).getImage().getScaledInstance(50, 50,
				Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);

		// set view
		view = new AdminUserInfoRegDlgView();
		add(view);

		// set combo box
		roleComboBox = view.getRoleComboBox();
		for (Permission p : Permission.values()) {
			roleComboBox.addItem(p);
		}
		roleComboBox.setSelectedIndex(3);
		roleComboBox.addActionListener(roleListener);
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

	public void register() {
		Permission selected = (Permission) roleComboBox.getSelectedItem();
		switch(selected) {
		case Student:
			Student student = (Student) view.getStudent().getData();
			userService.register(student.getUser().getId(), student.getUser().getName(), student.getUser().getEmail(), student.getUser().getNationality(), student.getUser().getPhoneNumber(), student.getUser().getAddress(), student.getUser().getResidentNumber(), student.getUser().getBirthdate(), student.getUser().getSex(), selected.getValue());
			studentService.register(student.getUser().getId(), student.getMajor(), student.getCampus());
			break;
		case Professor:
			Professor professor = (Professor) view.getProfessor().getData();
			userService.register(professor.getUser().getId(), professor.getUser().getName(), professor.getUser().getEmail(), professor.getUser().getNationality(), professor.getUser().getPhoneNumber(), professor.getUser().getAddress(), professor.getUser().getResidentNumber(), professor.getUser().getBirthdate(), professor.getUser().getSex(), professor.getUser().getRole().getValue());
			professorService.register(professor.getUser().getId(), professor.getFaculty(), professor.getDepartment());
			break;
		default:
			break;
		}
//		User user = (User) view.getData();
//		view.getStudent().getData();
//		userService.register(user.getId(), user.getName(), user.getEmail(), user.getNationality(), user.getPhoneNumber(), user.getAddress(), user.getResidentNumber(), user.getBirthdate(), user.getSex(), user.getRole().getValue());
	}

	public void cancel() {
		System.out.println("취소 완료");
	}

	private ActionListener roleListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Permission selected = (Permission) roleComboBox.getSelectedItem();
			switch (selected) {
			case Admin:
				showMessageBox("admin계정은 생성이 불가능합니다.");
				view.changeToStudent();
				break;
			case Student:
				view.changeToStudent();
				break;
			case Professor:
				view.changeToProfessor();
				break;
			default:
				break;
			}
		}
	};
}
