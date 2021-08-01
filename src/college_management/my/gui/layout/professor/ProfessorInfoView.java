package college_management.my.gui.layout.professor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import college_management.my.db.model.Professor;
import college_management.my.db.model.User;
import college_management.my.gui.layout.common.LecView;

@SuppressWarnings("serial")
public class ProfessorInfoView extends LecView{
	private JTextField facultyTxtField = new JTextField();
	private JTextField departmentTxtField = new JTextField();
	
	public ProfessorInfoView() {
		super();
		
		initLayout();
		setBackground(new Color(200, 200, 200));
	}
	
	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
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
	
	@Override
	public void setData(Object model) {
		Professor professor = (Professor) model;
		facultyTxtField.setText(professor.getFaculty());
		departmentTxtField.setText(professor.getDepartment());
	}

	@Override
	public Object getData() {
		Professor professor = new Professor();
//		User user = new User();
		professor.setFaculty(facultyTxtField.getText());
		professor.setDepartment(departmentTxtField.getText());
//		professor.setUser(user);
		return professor;
	}

}
