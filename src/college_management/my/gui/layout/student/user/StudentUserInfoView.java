package college_management.my.gui.layout.student.user;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JTextField;

import college_management.my.api.config.Permission;
import college_management.my.db.model.User;
import college_management.my.gui.layout.common.LecView;

public class StudentUserInfoView extends LecView{
	private JTextField idTxtField = new JTextField();
	private JTextField nameTxtField = new JTextField();
	private JTextField addressTxtField = new JTextField();
	private JTextField phoneTxtField = new JTextField();
	private JTextField countryTxtField = new JTextField();
	private JTextField residentTxtField = new JTextField();
	private JTextField emailTxtField = new JTextField();
	private JTextField birthTxtField = new JTextField();
	private JTextField sexTxtField = new JTextField();
	private JTextField pwdTxtField = new JTextField();
	private JTextField roleTxtField = new JTextField();

	public StudentUserInfoView() {
		super();

		initLayout();
	}

	private void initLayout() {
		setLayout(new GridBagLayout());
		
		int row = 0;
		addTxtField("아이디", idTxtField, row++, false);
		addTxtField("이름", nameTxtField, row++, true);
		addTxtField("주소", addressTxtField, row++, true);
		addTxtField("전화번호", phoneTxtField, row++, true);
		addTxtField("국적", countryTxtField, row++, false);
		addTxtField("주민등록번호", residentTxtField, row++, true);
		addTxtField("이메일", emailTxtField, row++, true);
		addTxtField("생년월일", birthTxtField, row++, false);
		addTxtField("성별", sexTxtField, row++, false);
		addTxtField("비밀번호", pwdTxtField, row++, true);
	}

	private void addTxtField(String name, JTextField txtField, int row, boolean isEditable) {
		GridBagConstraints c = new GridBagConstraints();

		JLabel label = new JLabel(name);
		label.setPreferredSize(new Dimension(100, 30));
		c.gridx = 0;
		c.gridy = row;
		add(label, c);
		
		txtField.setPreferredSize(new Dimension(200, 30));
		txtField.setEditable(isEditable);
		txtField.setBackground(isEditable ? Color.WHITE : Color.LIGHT_GRAY);
		c.gridx = 1;
		c.gridy = row;
		add(txtField, c);
	}

	@Override
	public void setData(Object model) {
		User user = (User) model;
		idTxtField.setText(user.getId());
		nameTxtField.setText(user.getName());
		addressTxtField.setText(user.getAddress());
		phoneTxtField.setText(user.getPhoneNumber());
		countryTxtField.setText(user.getNationality());
		residentTxtField.setText(user.getResidentNumber());
		emailTxtField.setText(user.getEmail());
		birthTxtField.setText(user.getBirthdate());
		sexTxtField.setText(user.getSex());
		pwdTxtField.setText(user.getPwd());
		roleTxtField.setText(user.getRole().getValue());
	}

	@Override
	public Object getData() {
		User user = new User();
		user.setId(idTxtField.getText());
		user.setName(nameTxtField.getText());
		user.setAddress(addressTxtField.getText());
		user.setPhoneNumber(phoneTxtField.getText());
		user.setNationality(countryTxtField.getText());
		user.setResidentNumber(residentTxtField.getText());
		user.setEmail(emailTxtField.getText());
		user.setBirthdate(birthTxtField.getText());
		user.setSex(sexTxtField.getText());
		user.setPwd(pwdTxtField.getText());
		user.setRole(Permission.valueOfType(roleTxtField.getText()));
		return user;
	}
}
