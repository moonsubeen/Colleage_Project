package college_management.my.gui.component.admin.user;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import college_management.my.api.config.Permission;
import college_management.my.db.model.User;
import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.TabPanel;
import college_management.my.gui.layout.admin.user.AdminUserLayout;
import college_management.my.gui.layout.common.LecTableView;
import college_management.my.gui.layout.common.LecView;

@SuppressWarnings("serial")
public class UserTab extends TabPanel{
	private LecTableView list;
	private LecView info;
	private JComboBox<String> roleComboBox;
	private JTextField searchTxtField;
	private AdminUserLayout layout;
	
	public UserTab(MainGUI frame) {
		super(frame);

		// set layout
		layout = new AdminUserLayout();
		add(layout);		
	}
	
	public void initLayout() {
		layout.initLayout();
		
		// set combo box				
		roleComboBox = layout.getRoleComboBox();
		for (Permission p : Permission.values()) {
			roleComboBox.addItem(p.getValue());
		}
		roleComboBox.setSelectedIndex(0);
		roleComboBox.addActionListener(roleListener);
		
		// set button
		JButton loadBtn = layout.getLoadBtn();
		JButton updateBtn = layout.getUpdateBtn();
		JButton registerBtn = layout.getRegisterBtn();
		JButton searchBtn = layout.getSearchBtn();
		JButton familyBtn = layout.getFamilyBtn();
		JLabel label = layout.getLabel();
				
		searchTxtField = layout.getSearchTxtField();
				
				
		loadBtn.addActionListener(loadListener);
		updateBtn.addActionListener(updateListener);
		registerBtn.addActionListener(registerListener);
		familyBtn.addActionListener(familyListener);		
		searchBtn.addActionListener(searchListener);

		// set list
		list = layout.getUserList();	
		info = layout.getUserInfo();	
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		refresh();
	}
	
	private void search() {
		if(auth.isLogin()) {
			List<User> users = new ArrayList<User>();
			users.add(userService.read(searchTxtField.getText()));
			list.setModel(new UserListTableAdapter(users));
		}
	}
	
	private void refresh() {
		if (auth.isLogin()) {
			List<User> users = userService.RolereadAll(roleComboBox.getSelectedItem().toString());
			list.setModel(new UserListTableAdapter(users));
		}
	}

	private ActionListener roleListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			refresh();
		}
	};

	private ActionListener loadListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			showMessageBox("목록 새로고침 완료");
			refresh();
		}
	};

	private ActionListener updateListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			User user = (User) info.getData();
			if (userService.update(user.getId(), user.getPwd(), user.getName(), user.getEmail(), user.getAddress(), user.getPhoneNumber())) {
				showMessageBox("업데이트 성공");
				refresh();
			}
		}
	};

	private ActionListener registerListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			UserRegDialog dlg = new UserRegDialog(frame);
			dlg.show();
		}
	};
	
	private ActionListener familyListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			User user = (User) info.getData();
			String id = user.getId();
			UserFamilyDialog dlgs = new UserFamilyDialog(frame);
			dlgs.show(id);
		}
	};

	private ActionListener searchListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			showMessageBox("검색 완료");
			search();
		}
	};
}
