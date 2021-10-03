package college_management.my.gui.layout.student.attendance;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import college_management.my.db.model.LectureAttendance;
import college_management.my.gui.layout.common.LecView;

public class StudentAttendanceInfoView extends LecView{
	private JTextField idTxtField = new JTextField();
	private JTextField nameTxtField = new JTextField();
	private JTextField codeTxtField = new JTextField();
	private JTextField titleTxtField = new JTextField();
	private JTextField monthTxtField = new JTextField();
	private JTextField dayTxtField = new JTextField();
	private JTextField attendanceTxtField = new JTextField();
	
	private LectureAttendance data;
	
	public StudentAttendanceInfoView() {
		super();
		
		initLayout();
	}
	
	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
		genInfoPair("학생 아이디", idTxtField, row++, false);
		genInfoPair("학생 이름", nameTxtField, row++, false);
		genInfoPair("강의 코드", codeTxtField, row++, false);
		genInfoPair("강의 제목", titleTxtField, row++, false);
		genInfoPair("월", monthTxtField, row++, false);
		genInfoPair("요일", dayTxtField, row++, false);
		genInfoPair("출석", attendanceTxtField, row++, false);
	}
	
	private void genInfoPair(String name, JTextField txtField, int row, boolean isEditable) {
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
	public void setData(Object attendance) {
		data = (LectureAttendance) attendance;
		idTxtField.setText(data.getStudent().getUser().getId());
		nameTxtField.setText(data.getStudent().getUser().getName());
		codeTxtField.setText(data.getLecture().getCode());
		titleTxtField.setText(data.getLecture().getName());
		monthTxtField.setText(data.getMonth());
		dayTxtField.setText(data.getDay());
		attendanceTxtField.setText(data.getAttendance());
	}

	@Override
	public Object getData() {
		data.setDay(dayTxtField.getText());
		data.setMonth(monthTxtField.getText());
		data.setAttendance(attendanceTxtField.getText());
		return data;
	}
}
