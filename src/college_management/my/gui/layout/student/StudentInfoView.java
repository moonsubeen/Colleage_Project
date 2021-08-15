package college_management.my.gui.layout.student;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JTextField;

import college_management.my.db.model.Student;
import college_management.my.db.model.User;
import college_management.my.gui.layout.common.LecView;

@SuppressWarnings("serial")
public class StudentInfoView extends LecView{
	private JTextField majorTxtField = new JTextField();
	private JTextField campusTxtField = new JTextField();
	private JTextField disTxtField = new JTextField();
	
	public StudentInfoView() {
		super();

		initLayout();
	}

	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
		genInfoPair("전공", majorTxtField, row++, false);
		genInfoPair("캠퍼스,", campusTxtField, row++, false);
//		genInfoPair("장애여부", disTxtField, row++, false);
	}

	private void genInfoPair(String name, JTextField txtField, int row, boolean isEditable) {
		GridBagConstraints c = new GridBagConstraints();

		JLabel label = new JLabel(name);
		label.setPreferredSize(new Dimension(100, 30));
		c.gridx = 0;
		c.gridy = row;
		add(label, c);

		txtField.setPreferredSize(new Dimension(200, 30));
		c.gridx = 1;
		c.gridy = row;
		add(txtField, c);
	}

	@Override
	public void setData(Object model) {
		Student student = (Student) model;
		majorTxtField.setText(student.getMajor());
		campusTxtField.setText(student.getCampus());
	}

	@Override
	public Object getData() {
		Student student = new Student();
//		User user = new User();
		student.setMajor(majorTxtField.getText());
		student.setCampus(campusTxtField.getText());
//		student.setUser(user);
		return student;
	}

}
