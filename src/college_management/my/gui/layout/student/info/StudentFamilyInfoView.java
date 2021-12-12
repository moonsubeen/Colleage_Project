package college_management.my.gui.layout.student.info;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import college_management.my.db.model.UserFamily;
import college_management.my.gui.layout.common.LecView;

public class StudentFamilyInfoView  extends LecView{
	private JTextField relationTxtField = new JTextField();
	private JTextField nameTxtField = new JTextField();
	private JTextField phoneNumberTxtField = new JTextField();
	
	public StudentFamilyInfoView() {
		super();
		
		initLayout();
	}
	
	private void initLayout() {
		setLayout(new GridBagLayout());
		
		int row = 0;
		addTxtField("가족관계", relationTxtField, row++, true);
		addTxtField("가족성함", nameTxtField, row++, true);
		addTxtField("가족전화번호", phoneNumberTxtField, row++, true);
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
		UserFamily family = (UserFamily) model;
		relationTxtField.setText(family.getRelation());
		nameTxtField.setText(family.getName());
		phoneNumberTxtField.setText(family.getPhoneNumber());
	}

	@Override
	public Object getData() {
		UserFamily family = new UserFamily();
		family.setRelation(relationTxtField.getText());
		family.setName(nameTxtField.getText());
		family.setPhoneNumber(phoneNumberTxtField.getText());
		return family;
	}
}
