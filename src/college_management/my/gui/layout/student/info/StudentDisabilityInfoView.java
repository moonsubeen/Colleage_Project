package college_management.my.gui.layout.student.info;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import college_management.my.db.model.UserDisability;
import college_management.my.gui.layout.common.LecView;

public class StudentDisabilityInfoView extends LecView{
	private JTextField stateTxtField = new JTextField();
	private JTextField nameTxtField = new JTextField();
	private JTextField documentTxtField = new JTextField();
	
	public StudentDisabilityInfoView() {
		super();
		
		initLayout();
	}
	
	private void initLayout() {
		setLayout(new GridBagLayout());
		
		int row = 0;
		addTxtField("병 여부", stateTxtField, row++, true);
		addTxtField("병명", nameTxtField, row++, true);
		addTxtField("병관련 문서 여부", documentTxtField, row++, true);
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
		UserDisability dis = (UserDisability) model;
		stateTxtField.setText(dis.getState());
		nameTxtField.setText(dis.getDisability());
		documentTxtField.setText(dis.getDocument());
	}

	@Override
	public Object getData() {
		UserDisability dis = new UserDisability();
		dis.setState(stateTxtField.getText());
		dis.setDisability(nameTxtField.getText());
		dis.setDocument(documentTxtField.getText());
		return dis;
	}
}
