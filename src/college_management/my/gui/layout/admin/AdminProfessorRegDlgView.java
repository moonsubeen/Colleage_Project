package college_management.my.gui.layout.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import college_management.my.db.model.Professor;
import college_management.my.db.model.User;
import college_management.my.gui.layout.common.LecView;

@SuppressWarnings("serial")
public class AdminProfessorRegDlgView extends LecView{
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
	private JTextField facultyTxtField = new JTextField();
	private JTextField departmentTxtField = new JTextField();
	
//	private HashMap<String, JComponent> infoMap = new HashMap<String, JComponent>();

	public AdminProfessorRegDlgView() {
		super();

		initLayout();
		setBackground(new Color(200, 200, 200));
	}

	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
		addTextFieldPair("교수 코드", idTxtField, row++, true);
		addTextFieldPair("이름", nameTxtField, row++, true);
		addTextFieldPair("주소", addressTxtField, row++, true);
		addTextFieldPair("전화번호", phoneTxtField, row++, true);
		addTextFieldPair("국적", countryTxtField, row++, true);
		addTextFieldPair("주민등록번호", residentTxtField, row++, true);
		addTextFieldPair("이메일", emailTxtField, row++, true);
		addTextFieldPair("생년월일", birthTxtField, row++, true);
		addTextFieldPair("성별", sexTxtField, row++, true);
		addTextFieldPair("비밀번호", pwdTxtField, row++, true);
		addTextFieldPair("학부", facultyTxtField, row++, true);
		addTextFieldPair("학적", departmentTxtField, row++, true);
	}

	private void addTextFieldPair(String name, JTextField txtField, int row, boolean isEditable) {
		GridBagConstraints c = new GridBagConstraints();

		JLabel label = new JLabel(name);
		label.setPreferredSize(new Dimension(100, 30));
		c.gridx = 0;
		c.gridy = row;
		add(label, c);

		JTextField field = new JTextField();
		field.setPreferredSize(new Dimension(200, 30));
		c.gridx = 1;
		c.gridy = row;
		add(field, c);
	}

//	private void genComboBoxPair(String id, String name, int row) {
//		GridBagConstraints c = new GridBagConstraints();
//
//		JLabel label = new JLabel(name);
//		label.setPreferredSize(new Dimension(100, 30));
//		c.gridx = 0;
//		c.gridy = row;
//		add(label, c);
//
//		JComboBox<String> comboBox = new JComboBox<String>();
//		c.gridx = 1;
//		c.gridy = row;
//		add(comboBox, c);
//
//		infoMap.put(id, comboBox);
//	}

	@Override
	public void setData(Object model) {
		Professor professor = (Professor) model;
		User user = professor.getUser();
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
		facultyTxtField.setText(professor.getFaculty());
		departmentTxtField.setText(professor.getDepartment());
		
//		((JTextField) infoMap.get("id")).setText(user.getId());
//		((JTextField) infoMap.get("name")).setText(user.getName());
//		((JTextField) infoMap.get("address")).setText(user.getAddress());
//		((JTextField) infoMap.get("phone")).setText(user.getPhoneNumber());
//		((JTextField) infoMap.get("country")).setText(user.getNationality());
//		((JTextField) infoMap.get("regdent")).setText(user.getResidentNumber());
//		((JTextField) infoMap.get("email")).setText(user.getEmail());
//		((JTextField) infoMap.get("birth")).setText(user.getBirthdate());
//		((JTextField) infoMap.get("pwd")).setText(user.getPwd());
//		((JTextField) infoMap.get("dep")).setText(professor.getDepartment());
//		((JTextField) infoMap.get("fac")).setText(professor.getFaculty());
	}

	@Override
	public Object getData() {
		Professor professor = new Professor();
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
		professor.setFaculty(facultyTxtField.getText());
		professor.setDepartment(departmentTxtField.getText());
		professor.setUser(user);
		
//		user.setId(((JTextField) infoMap.get("id")).getText());
//		user.setName(((JTextField) infoMap.get("name")).getText());
//		user.setAddress(((JTextField) infoMap.get("address")).getText());
//		user.setPhoneNumber(((JTextField) infoMap.get("phone")).getText());
//		user.setNationality(((JTextField) infoMap.get("country")).getText());
//		user.setResidentNumber(((JTextField) infoMap.get("regdent")).getText());
//		user.setEmail(((JTextField) infoMap.get("email")).getText());
//		user.setBirthdate(((JTextField) infoMap.get("birth")).getText());
//		user.setPwd(((JTextField) infoMap.get("pwd")).getText());

//		Division div = new Division();
//		div.setCode("code");
//		div.setName("name");
//		professor.setDiv(div);
//
//		Department dep = new Department();
//		dep.setCode("code");
//		dep.setName("name");
//		professor.setDep(dep);
		return professor;
	}

//	@SuppressWarnings("unchecked")
//	public JComboBox<Division> getDivComboBox() {
//		return (JComboBox<Division>) infoMap.get("div");
//	}
//
//	@SuppressWarnings("unchecked")
//	public JComboBox<Department> getDepComboBox() {
//		return (JComboBox<Department>) infoMap.get("dep");
//	}
}
