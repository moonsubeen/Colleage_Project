package college_management.my.gui.layout.student.info;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import college_management.my.db.model.UserSoldier;
import college_management.my.gui.layout.common.LecView;

public class StudentSoldierInfoView extends LecView{
	private JTextField stateTxtField = new JTextField();
	private JTextField militaryNumberTxtField = new JTextField();
	private JTextField typeTxtField = new JTextField();
	private JTextField classificationTxtField = new JTextField();
	private JTextField branchTxtField = new JTextField();
	private JTextField ranksTxtField = new JTextField();
	private JTextField joinDateTxtField = new JTextField();
	private JTextField dischageDateTxtField = new JTextField();
	
	public StudentSoldierInfoView() {
		super();
		
		initLayout();
	}
	
	private void initLayout() {
		setLayout(new GridBagLayout());
		
		int row = 0;
		addTxtField("군입대 여부", stateTxtField, row++, true);
		addTxtField("군번", militaryNumberTxtField, row++, true);
		addTxtField("군별", typeTxtField, row++, true);
		addTxtField("역종", classificationTxtField, row++, true);
		addTxtField("특기", branchTxtField, row++, true);
		addTxtField("계급", ranksTxtField, row++, true);
		addTxtField("입대일자", joinDateTxtField, row++, true);
		addTxtField("전역일자", dischageDateTxtField, row++, true);
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
		UserSoldier soldier = (UserSoldier) model;
		stateTxtField.setText(soldier.getState());
		militaryNumberTxtField.setText(soldier.getMilitaryNumber());
		typeTxtField.setText(soldier.getType());
		classificationTxtField.setText(soldier.getClassification());
		branchTxtField.setText(soldier.getBranch());
		ranksTxtField.setText(soldier.getRank());
		joinDateTxtField.setText(soldier.getJoinDate());
		dischageDateTxtField.setText(soldier.getDischageDate());
	}

	@Override
	public Object getData() {
		UserSoldier soldier = new UserSoldier();
		soldier.setState(stateTxtField.getText());
		soldier.setMilitaryNumber(militaryNumberTxtField.getText());
		soldier.setType(typeTxtField.getText());
		soldier.setClassification(classificationTxtField.getText());
		soldier.setBranch(branchTxtField.getText());
		soldier.setRank(ranksTxtField.getText());
		soldier.setJoinDate(joinDateTxtField.getText());
		soldier.setDischageDate(dischageDateTxtField.getText());
		return soldier;
	}
}
