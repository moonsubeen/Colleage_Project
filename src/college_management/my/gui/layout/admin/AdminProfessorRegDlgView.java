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
	private HashMap<String, JComponent> infoMap = new HashMap<String, JComponent>();

	public AdminProfessorRegDlgView() {
		super();

		initLayout();
		setBackground(new Color(200, 200, 200));
	}

	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
		genTextFieldPair("id", "교수 학번", row++);
		genTextFieldPair("name", "이름", row++);
		genTextFieldPair("address", "주소", row++);
		genTextFieldPair("phone", "전화번호", row++);
		genTextFieldPair("country", "국적", row++);
		genTextFieldPair("regdent", "주민등록번호", row++);
		genTextFieldPair("email", "이메일", row++);
		genTextFieldPair("birth", "생년월일", row++);
		genTextFieldPair("pwd", "비밀번호", row++);
		genComboBoxPair("dep", "학적", row++);
		genComboBoxPair("fac", "학부", row++);
	}

	private void genTextFieldPair(String id, String name, int row) {
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

		infoMap.put(id, field);
	}

	private void genComboBoxPair(String id, String name, int row) {
		GridBagConstraints c = new GridBagConstraints();

		JLabel label = new JLabel(name);
		label.setPreferredSize(new Dimension(100, 30));
		c.gridx = 0;
		c.gridy = row;
		add(label, c);

		JComboBox<String> comboBox = new JComboBox<String>();
		c.gridx = 1;
		c.gridy = row;
		add(comboBox, c);

		infoMap.put(id, comboBox);
	}

	@Override
	public void setData(Object model) {
		Professor professor = (Professor) model;
		User user = professor.getUser();
		((JTextField) infoMap.get("id")).setText(user.getId());
		((JTextField) infoMap.get("name")).setText(user.getName());
		((JTextField) infoMap.get("address")).setText(user.getAddress());
		((JTextField) infoMap.get("phone")).setText(user.getPhoneNumber());
		((JTextField) infoMap.get("country")).setText(user.getNationality());
		((JTextField) infoMap.get("regdent")).setText(user.getResidentNumber());
		((JTextField) infoMap.get("email")).setText(user.getEmail());
		((JTextField) infoMap.get("birth")).setText(user.getBirthdate());
		((JTextField) infoMap.get("pwd")).setText(user.getPwd());
		((JTextField) infoMap.get("dep")).setText(professor.getDepartment());
		((JTextField) infoMap.get("fac")).setText(professor.getFaculty());
	}

	@Override
	public Object getData() {
		Professor professor = new Professor();
		User user = new User();
		user.setId(((JTextField) infoMap.get("id")).getText());
		user.setName(((JTextField) infoMap.get("name")).getText());
		user.setAddress(((JTextField) infoMap.get("address")).getText());
		user.setPhoneNumber(((JTextField) infoMap.get("phone")).getText());
		user.setNationality(((JTextField) infoMap.get("country")).getText());
		user.setResidentNumber(((JTextField) infoMap.get("regdent")).getText());
		user.setEmail(((JTextField) infoMap.get("email")).getText());
		user.setBirthdate(((JTextField) infoMap.get("birth")).getText());
		user.setPwd(((JTextField) infoMap.get("pwd")).getText());
		professor.setUser(user);

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
