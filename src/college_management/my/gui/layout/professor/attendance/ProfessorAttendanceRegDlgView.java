package college_management.my.gui.layout.professor.attendance;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import college_management.my.db.model.LectureAttendance;
import college_management.my.gui.layout.common.LecView;

public class ProfessorAttendanceRegDlgView extends LecView{
	private JTextField codeTxtField = new JTextField();
	private JTextField idTxtField = new JTextField();
	private JTextField monthTxtField = new JTextField();
	private JTextField dayTxtField = new JTextField();
	private JTextField attendanceTxtField = new JTextField();
	
	private LectureAttendance data;
	
	public ProfessorAttendanceRegDlgView() {
		super();
		
		initLayout();
		setBackground(new Color(200, 200, 200));
	}
	
	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
		addTextFieldPair("강의코드", codeTxtField, row++, true);
		addTextFieldPair("학생학번", idTxtField, row++, true);
		addTextFieldPair("월", monthTxtField, row++, true);
		addTextFieldPair("일", dayTxtField, row++, true);
		addTextFieldPair("출석", attendanceTxtField, row++, true);
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

	public JTextField getCodeTxtField() {
		return codeTxtField;
	}
	
	public JTextField getIdTxtField() {
		return idTxtField;
	}

	public JTextField getMonthTxtField() {
		return monthTxtField;
	}
	
	public JTextField getDayTxtField() {
		return dayTxtField;
	}

	public JTextField getAttendanceTxtField() {
		return attendanceTxtField;
	}

	@Override
	public void setData(Object attendance) {
		data = (LectureAttendance) attendance;
		codeTxtField.setText(data.getLecture().getCode());
		idTxtField.setText(data.getStudent().getUser().getId());
		monthTxtField.setText(data.getMonth());
		dayTxtField.setText(data.getDay());
		attendanceTxtField.setText(data.getAttendance());
	}

	@Override
	public Object getData() {
		LectureAttendance attendance = new LectureAttendance();
		attendance.setMonth(monthTxtField.getText());
		attendance.setDay(dayTxtField.getText());
		attendance.setAttendance(attendanceTxtField.getText());
		return attendance;
	}
}
