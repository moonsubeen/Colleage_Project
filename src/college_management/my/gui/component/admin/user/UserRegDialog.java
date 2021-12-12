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
import college_management.my.gui.layout.admin.user.AdminUserInfoRegDlgView;

public class UserRegDialog extends LecPanel implements Serializable{
	private AdminUserInfoRegDlgView view;
	private ImageIcon icon;
	private String title = "사용자 추가 등록하기";
	private Object[] options = new Object[] { "추가", "취소" };

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
			showMessageBox("등록이 성공했습니다.");
			register();
		} else {
			showMessageBox("취소가 성공했습니다.");
			cancel();
		}
	}

	public void register() {
		Permission selected = (Permission) roleComboBox.getSelectedItem();
		String select = (String) view.getStudent().getSoldierStateComboBox().getSelectedItem();
		String select2 = (String) view.getStudent().getDisabilityStateComboBox().getSelectedItem();
		
		switch(selected) {
		case Student:
			Student student = (Student) view.getStudent().getData();
			userService.register(student.getUser().getId(), student.getUser().getName(), student.getUser().getEmail(), student.getUser().getNationality(), student.getUser().getPhoneNumber(), student.getUser().getAddress(), student.getUser().getResidentNumber(), student.getUser().getBirthdate(), student.getUser().getSex(), selected.getValue());
			studentService.register(student.getUser().getId(), student.getMajor(), student.getCampus());
			if(select.equals("없음") || select.equals("해당사항 아님"))
				infoService.register(student.getUser().getId(), select, "", "", "", "", "", "", "");
			if(select2.equals("없음"))
				infoService.register(student.getUser().getId(), select2, "", "");
			break;
		case Professor:
			Professor professor = (Professor) view.getProfessor().getData();
			userService.register(professor.getUser().getId(), professor.getUser().getName(), professor.getUser().getEmail(), professor.getUser().getNationality(), professor.getUser().getPhoneNumber(), professor.getUser().getAddress(), professor.getUser().getResidentNumber(), professor.getUser().getBirthdate(), professor.getUser().getSex(), selected.getValue());
			professorService.register(professor.getUser().getId(), professor.getFaculty(), professor.getDepartment());
			if(select.equals("없음") || select.equals("해당사항 아님"))
				infoService.register(professor.getUser().getId(), select, "", "", "", "", "", "", "");
			if(select2.equals("없음"))
				infoService.register(professor.getUser().getId(), select2, "", "");
			break;
		default:
			break;
		}
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
