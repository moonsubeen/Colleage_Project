package college_management.my.gui.component.admin.user;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import college_management.my.api.config.Permission;
import college_management.my.db.model.Lecture;
import college_management.my.db.model.UserFamily;
import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.LecPanel;
import college_management.my.gui.layout.admin.user.AdminBaseFamilyRegDlgView;
import college_management.my.gui.layout.admin.user.AdminFamilyRegDlgView;

public class UserFamilyDialog extends LecPanel implements Serializable{
	private AdminBaseFamilyRegDlgView view;
	private ImageIcon icon;
	private String title = "사용자 가족정보 등록하기";
	private Object[] options = new Object[] { "추가", "취소" };
	private JComboBox<String> relationComboBox;
	
	public UserFamilyDialog(MainGUI frame) {
		super(frame);
		
		// set dialog image
		Image img = (new ImageIcon("src/resource/new_user.png")).getImage().getScaledInstance(50, 50,
				Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);
		
		view = new AdminBaseFamilyRegDlgView();
		add(view);
		
		relationComboBox = view.getComboBox();
	}
	
	public void show(String id) {
		int selected = JOptionPane.showOptionDialog(null, view, title, JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, icon, options, options[0]);
		if (selected == 0) {
			showMessageBox("등록이 성공했습니다.");
			register(id);
		} else {
			showMessageBox("취소가 성공했습니다.");
			cancel();
		}
	}
	
	public void cancel() {
		System.out.println("취소 완료");
	}
	
	public void register(String id) {
		String relation = (String) relationComboBox.getSelectedItem();
		UserFamily family = (UserFamily) view.getFamily().getData();
		switch(relation) {
		case "부":
			userService.register(id, family.getName(), relation, family.getPhoneNumber());
			break;
		case "모":
			userService.register(id, family.getName(), relation, family.getPhoneNumber());
			break;
		case "형":
			userService.register(id, family.getName(), relation, family.getPhoneNumber());
			break;
		case "제":
			userService.register(id, family.getName(), relation, family.getPhoneNumber());
			break;
		case "자":
			userService.register(id, family.getName(), relation, family.getPhoneNumber());
			break;
		case "매":
			userService.register(id, family.getName(), relation, family.getPhoneNumber());
			break;
		default:
			break;
		}
	}

}
