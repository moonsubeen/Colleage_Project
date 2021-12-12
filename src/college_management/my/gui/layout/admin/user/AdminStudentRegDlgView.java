package college_management.my.gui.layout.admin.user;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import college_management.my.api.config.Permission;
import college_management.my.db.model.Student;
import college_management.my.db.model.User;
import college_management.my.gui.layout.common.LecView;

@SuppressWarnings("serial")
public class AdminStudentRegDlgView extends LecView{
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
	private JTextField majorTxtField = new JTextField();
	private JTextField campusTxtField = new JTextField();
	String states[] = {"없음", "있음", "해당사항 아님"};
	String state2[] = {"없음", "있음"};
	private JComboBox<String> soldierstate = new JComboBox<String>(states);
	private JComboBox<String> disabilitystate = new JComboBox<String>(state2);
	
	public AdminStudentRegDlgView() {
		super();

		initLayout();
		setBackground(new Color(200, 200, 200));
	}

	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
		addComboBoxPair(soldierstate, "복무여부", row++);
		addComboBoxPair(disabilitystate, "병여부", row++);
		addTextFieldPair("학생 학번", idTxtField, row++, true);
		addTextFieldPair("이름", nameTxtField, row++, true);
		addTextFieldPair("주소", addressTxtField, row++, true);
		addTextFieldPair("전화번호", phoneTxtField, row++, true);
		addTextFieldPair("국적", countryTxtField, row++, true);
		addTextFieldPair("주민등록번호", residentTxtField, row++, true);
		addTextFieldPair("이메일", emailTxtField, row++, true);
		addTextFieldPair("생년월일", birthTxtField, row++, true);
		addTextFieldPair("성별", sexTxtField, row++, true);
		addTextFieldPair("학과", majorTxtField, row++, true);
		addTextFieldPair("캠퍼스", campusTxtField, row++, true);
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
	
	private void addComboBoxPair(JComboBox<String> state, String name, int row) {
		GridBagConstraints c = new GridBagConstraints();

		JLabel label = new JLabel(name);
		label.setPreferredSize(new Dimension(100, 30));
		c.gridx = 0;
		c.gridy = row;
		add(label, c);

		c.gridx = 1;
		c.gridy = row;
		add(state, c);
	}

	@Override
	public void setData(Object model) {
		Student student = (Student) model;
		User user = student.getUser();
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
		majorTxtField.setText(student.getMajor());
		campusTxtField.setText(student.getCampus());
	}

	@Override
	public Object getData() {
		Student student = new Student();
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
		student.setMajor(majorTxtField.getText());
		student.setCampus(campusTxtField.getText());
		student.setUser(user);
		return student;
	}
	
	@SuppressWarnings("unchecked")
	public JComboBox<String> getSoldierStateComboBox() {
		return soldierstate;
	}
	
	@SuppressWarnings("unchecked")
	public JComboBox<String> getDisabilityStateComboBox() {
		return disabilitystate;
	}
}
