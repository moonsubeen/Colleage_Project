package college_management.my.gui.layout.admin.user;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import college_management.my.db.model.User;
import college_management.my.db.model.UserFamily;
import college_management.my.gui.layout.common.LecView;

public class AdminFamilyRegDlgView extends LecView{
//	private JTextField idTxtField = new JTextField();
	private JTextField nameTxtField = new JTextField();
	private JTextField phoneNumberTxtField = new JTextField();
	
	public AdminFamilyRegDlgView(){
		super();

		initLayout();
		setBackground(new Color(200, 200, 200));
	}
	
	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
//		addTextFieldPair("학생 학번", idTxtField, row++, false);
		addTextFieldPair("이름", nameTxtField, row++, true);
		addTextFieldPair("전화번호", phoneNumberTxtField, row++, true);
	}

	private void addTextFieldPair(String name, JTextField txtField, int row, boolean isEditable) {
		GridBagConstraints c = new GridBagConstraints();

		JLabel label = new JLabel(name);
		label.setPreferredSize(new Dimension(100, 30));
		c.gridx = 0;
		c.gridy = row;
		add(label, c);
		
		txtField.setEditable(isEditable);
		txtField.setPreferredSize(new Dimension(200, 30));
		c.gridx = 1;
		c.gridy = row;
		add(txtField, c);
	}
	
	@Override
	public void setData(Object model) {
		UserFamily family = (UserFamily) model;
		User user = family.getUser();
//		idTxtField.setText(user.getId());
		nameTxtField.setText(family.getName());
		phoneNumberTxtField.setText(family.getPhoneNumber());
	}

	@Override
	public Object getData() {
		UserFamily family = new UserFamily();
		User user = new User();
//		user.setId(idTxtField.getText());
		family.setName(nameTxtField.getText());
		family.setPhoneNumber(phoneNumberTxtField.getText());
		family.setUser(user);
		return family;
	}

}
